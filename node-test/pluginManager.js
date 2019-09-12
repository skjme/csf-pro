var plugins = pluginsApis = {},
    mongo = require('mongoskin'),
    cluster = require('cluster'),
    fs = require('fs'),
   path = require('path'),
   url = require('url'),
   querystring = require('querystring'),
   cp = require('child_process'),
//    async = require("async"),
   _ = require('underscore'),
    log = require('./utils/log.js'),
    logDbRead = log('db:read'),
    logDbWrite = log('db:write');


var pluginManager = function pluginManager() {

   /**
    * Get database connection with configured pool size
    * @param {object} config - connection configs
    * @returns {object} db connection params
    **/
   this.dbConnection = function(config) {
    if (process.argv[1].endsWith('executor.js') && (!config || !config.mongodb || config.mongodb.max_pool_size !== 1)) {
        console.log('************************************ executor.js common.db ***********************************', process.argv);
        return this.singleDefaultConnection();
    }

    var db, maxPoolSize = 10;
    if (!cluster.isMaster) {
        //we are in worker
        maxPoolSize = 100;
    }
    if (typeof config === "string") {
        db = config;
        if (this.dbConfigFiles[config]) {
            try {
                //try loading custom config file
                var conf = require(this.dbConfigFiles[config]);
                config = JSON.parse(JSON.stringify(conf));
            }
            catch (ex) {
                //user default config
                config = JSON.parse(JSON.stringify(countlyConfig));
            }
        }
        else {
            //user default config
            config = JSON.parse(JSON.stringify(countlyConfig));
        }
    }
    else {
        config = config || JSON.parse(JSON.stringify(countlyConfig));
    }

    if (config && typeof config.mongodb === "string") {
        var urlParts = url.parse(config.mongodb, true);
        if (urlParts && urlParts.query && urlParts.query.maxPoolSize) {
            maxPoolSize = urlParts.query.maxPoolSize;
        }
    }
    else {
        maxPoolSize = config.mongodb.max_pool_size || maxPoolSize;
    }

    var dbName;
    var dbOptions = {
        poolSize: maxPoolSize,
        reconnectInterval: 1000,
        reconnectTries: 999999999,
        autoReconnect: true,
        noDelay: true,
        keepAlive: true,
        keepAliveInitialDelay: 30000,
        connectTimeoutMS: 999999999,
        socketTimeoutMS: 999999999,
        useNewUrlParser: true
    };
    if (typeof config.mongodb === 'string') {
        dbName = this.replaceDatabaseString(config.mongodb, db);
    }
    else {
        config.mongodb.db = db || config.mongodb.db || 'countly';
        if (typeof config.mongodb.replSetServers === 'object') {
            //mongodb://db1.example.net,db2.example.net:2500/?replicaSet=test
            dbName = config.mongodb.replSetServers.join(',') + '/' + config.mongodb.db;
            if (config.mongodb.replicaName) {
                dbOptions.replicaSet = config.mongodb.replicaName;
            }
        }
        else {
            dbName = (config.mongodb.host + ':' + config.mongodb.port + '/' + config.mongodb.db);
        }
    }

    if (config.mongodb.dbOptions) {
        _.extend(dbOptions, config.mongodb.dbOptions);
    }

    if (config.mongodb.serverOptions) {
        _.extend(dbOptions, config.mongodb.serverOptions);
    }

    if (config.mongodb.username && config.mongodb.password) {
        dbName = encodeURIComponent(config.mongodb.username) + ":" + encodeURIComponent(utils.decrypt(config.mongodb.password)) + "@" + dbName;
    }

    if (dbName.indexOf('mongodb://') !== 0) {
        dbName = 'mongodb://' + dbName;
    }

    try {
        dbOptions.appname = process.title + ": " + dbName.split("/").pop().split("?")[0] + "(" + maxPoolSize + ") " + process.pid;
    }
    catch (ex) {
        //silent
    }

    var countlyDb = mongo.db(dbName, dbOptions);
    countlyDb._cly_debug = {
        db: dbName,
        options: dbOptions
    };
    logDbRead.d("New connection %j", countlyDb._cly_debug);
    countlyDb._emitter.setMaxListeners(0);
    if (!countlyDb.ObjectID) {
        countlyDb.ObjectID = function(id) {
            try {
                return mongo.ObjectID(id);
            }
            catch (ex) {
                logDbRead.i("Incorrect Object ID %j", ex);
                return id;
            }
        };
    }
    countlyDb.encode = function(str) {
        return str.replace(/^\$/g, "&#36;").replace(/\./g, '&#46;');
    };

    countlyDb.decode = function(str) {
        return str.replace(/^&#36;/g, "$").replace(/&#46;/g, '.');
    };
    countlyDb.on('error', console.log);
    countlyDb.onOpened = function(callback) {
        if (countlyDb.isOpen()) {
            callback();
        }
        else {
            countlyDb._emitter.once('open', function() {
                callback();
            });
        }
    };

    countlyDb.admin().buildInfo({}, (err, result) => {
        if (!err && result) {
            countlyDb.build = result;
        }
    });

    countlyDb.s = {};
    countlyDb._collection_cache = {};
    //overwrite some methods
    countlyDb._collection = countlyDb.collection;
    countlyDb.collection = function(collection, opts, done) {
        if (countlyDb._collection_cache[collection]) {
            return countlyDb._collection_cache[collection];
        }

        /**
        * Copy arguments for logging purposes
        * @param {vary} arg - argument value
        * @param {string} name - argument name
        * @returns {object} data with arguments
        **/
        function copyArguments(arg, name) {
            var data = {};
            data.name = name || arg.callee;
            data.args = [];
            for (let i = 0; i < arg.length; i++) {
                data.args.push(arg[i]);
            }
            return data;
        }

        //get original collection object
        var ob = this._collection(collection, opts, done);

        //overwrite with retry policy
        var retryifNeeded = function(callback, retry, e, data) {
            return function(err, res) {
                if (err) {
                    if (retry && err.code === 11000) {
                        if (typeof retry === "function") {
                            logDbWrite.d("Retrying writing " + collection + " %j", data);
                            logDbWrite.d("From connection %j", countlyDb._cly_debug);
                            retry();
                        }
                        else {
                            if (!(data.args && data.args[2] && data.args[2].ignore_errors && data.args[2].ignore_errors.indexOf(err.code) !== -1)) {
                                logDbWrite.e("Error writing " + collection + " %j %s %j", data, err, err);
                                logDbWrite.d("From connection %j", countlyDb._cly_debug);
                                if (e) {
                                    logDbWrite.e(e.stack);
                                }
                            }
                            if (callback) {
                                callback(err, res);
                            }
                            else {
                                logDbWrite.d("Without Callback");
                            }
                        }
                    }
                    else {
                        if (!(data.args && data.args[2] && data.args[2].ignore_errors && data.args[2].ignore_errors.indexOf(err.code) !== -1)) {
                            logDbWrite.e("Error writing " + collection + " %j %s %j", data, err, err);
                            logDbWrite.d("From connection %j", countlyDb._cly_debug);
                            if (e) {
                                logDbWrite.e(e.stack);
                            }
                        }
                        if (callback) {
                            callback(err, res);
                        }
                        else {
                            logDbWrite.d("Without Callback");
                        }
                    }
                }
                else if (callback) {
                    callback(err, res);
                }
                else {
                    logDbWrite.d("Without Callback");
                }
            };
        };

        ob._findAndModify = ob.findAndModify;
        ob.findAndModify = function(query, sort, doc, options, callback) {
            var e;
            var args = arguments;
            var at = "";
            if (log.getLevel("db") === "debug" || log.getLevel("db") === "info") {
                e = new Error();
                at += e.stack.replace(/\r\n|\r|\n/g, "\n").split("\n")[2];
            }
            if (typeof options === "function") {
                //options was not passed, we have callback
                logDbWrite.d("findAndModify " + collection + " %j %j %j" + at, query, sort, doc);
                logDbWrite.d("From connection %j", countlyDb._cly_debug);
                return this._findAndModify(query, sort, doc, retryifNeeded(options, null, e, copyArguments(arguments, "findAndModify")));
            }
            else {
                //we have options
                logDbWrite.d("findAndModify " + collection + " %j %j %j %j" + at, query, sort, doc, options);
                logDbWrite.d("From connection %j", countlyDb._cly_debug);
                if (options.upsert) {
                    var self = this;

                    return this._findAndModify(query, sort, doc, options, retryifNeeded(callback, function() {
                        logDbWrite.d("retrying findAndModify " + collection + " %j %j %j %j" + at, query, sort, doc, options);
                        logDbWrite.d("From connection %j", countlyDb._cly_debug);
                        self._findAndModify(query, sort, doc, options, retryifNeeded(callback, null, e, copyArguments(args, "findAndModify")));
                    }, e, copyArguments(arguments, "findAndModify")));
                }
                else {
                    return this._findAndModify(query, sort, doc, options, retryifNeeded(callback, null, e, copyArguments(arguments, "findAndModify")));
                }
            }
        };

        var overwriteRetryWrite = function(obj, name) {
            obj["_" + name] = obj[name];
            obj[name] = function(selector, doc, options, callback) {
                var args = arguments;
                var e;
                var at = "";
                if (log.getLevel("db") === "debug" || log.getLevel("db") === "info") {
                    e = new Error();
                    at += e.stack.replace(/\r\n|\r|\n/g, "\n").split("\n")[2];
                }
                if (typeof options === "function") {
                    //options was not passed, we have callback
                    logDbWrite.d(name + " " + collection + " %j %j" + at, selector, doc);
                    logDbWrite.d("From connection %j", countlyDb._cly_debug);
                    return this["_" + name](selector, doc, retryifNeeded(options, null, e, copyArguments(arguments, name)));
                }
                else {
                    options = options || {};
                    //we have options
                    logDbWrite.d(name + " " + collection + " %j %j %j" + at, selector, doc, options);
                    logDbWrite.d("From connection %j", countlyDb._cly_debug);
                    if (options.upsert) {
                        var self = this;

                        return this["_" + name](selector, doc, options, retryifNeeded(callback, function() {
                            logDbWrite.d("retrying " + name + " " + collection + " %j %j %j" + at, selector, doc, options);
                            logDbWrite.d("From connection %j", countlyDb._cly_debug);
                            self["_" + name](selector, doc, options, retryifNeeded(callback, null, e, copyArguments(args, name)));
                        }, e, copyArguments(arguments, name)));
                    }
                    else {
                        return this["_" + name](selector, doc, options, retryifNeeded(callback, null, e, copyArguments(arguments, name)));
                    }
                }
            };
        };

        overwriteRetryWrite(ob, "updateOne");
        overwriteRetryWrite(ob, "updateMany");
        overwriteRetryWrite(ob, "replaceOne");

        //overwrite with write logging
        var logForWrites = function(callback, e, data) {
            return function(err, res) {
                if (err) {
                    if (!(data.args && data.args[1] && data.args[1].ignore_errors && data.args[1].ignore_errors.indexOf(err.code) !== -1)) {
                        logDbWrite.e("Error writing " + collection + " %j %s %j", data, err, err);
                        logDbWrite.d("From connection %j", countlyDb._cly_debug);
                        if (e) {
                            logDbWrite.e(e.stack);
                        }
                    }
                }
                // new returned id format
                if (res) {
                    if (res.insertedIds) {
                        var arr = [];
                        for (let i in res.insertedIds) {
                            arr.push(res.insertedIds[i]);
                        }
                        res.insertedIdsOrig = res.insertedIds;
                        res.insertedIds = arr;
                    }
                    else if (res.insertedId) {
                        res.insertedIds = [res.insertedId];
                    }
                }
                if (callback) {
                    callback(err, res);
                }
                else {
                    logDbWrite.d("Without Callback");
                    /*if (e) {
                        logDbWrite.e(e.stack);
                    }*/
                }
            };
        };

        var overwriteDefaultWrite = function(obj, name) {
            obj["_" + name] = obj[name];
            obj[name] = function(selector, options, callback) {
                var e;
                var at = "";
                if (log.getLevel("db") === "debug" || log.getLevel("db") === "info") {
                    e = new Error();
                    at += e.stack.replace(/\r\n|\r|\n/g, "\n").split("\n")[2];
                }
                if (typeof options === "function") {
                    //options was not passed, we have callback
                    logDbWrite.d(name + " " + collection + " %j" + at, selector);
                    logDbWrite.d("From connection %j", countlyDb._cly_debug);
                    return this["_" + name](selector, logForWrites(options, e, copyArguments(arguments, name)));
                }
                else {
                    //we have options
                    logDbWrite.d(name + " " + collection + " %j %j" + at, selector, options);
                    logDbWrite.d("From connection %j", countlyDb._cly_debug);
                    return this["_" + name](selector, options, logForWrites(callback, e, copyArguments(arguments, name)));
                }
            };
        };
        overwriteDefaultWrite(ob, "deleteOne");
        overwriteDefaultWrite(ob, "deleteMany");
        overwriteDefaultWrite(ob, "insertOne");
        overwriteDefaultWrite(ob, "insertMany");
        overwriteDefaultWrite(ob, "save");

        //overwrite with read logging
        var logForReads = function(callback, e, data) {
            return function(err, res) {
                if (err) {
                    logDbRead.e("Error reading " + collection + " %j %s %j", data, err, err);
                    logDbRead.d("From connection %j", countlyDb._cly_debug);
                    if (e) {
                        logDbRead.e(e.stack);
                    }
                }
                if (callback) {
                    //aggregation to result conversion
                    if (data.name === "aggregate" && !err && res && res.toArray) {
                        if (data.args.length >= 2 && data.args[1].cursor) {
                            callback(err, res);
                        }
                        else {
                            res.toArray(function(err2, result) {
                                callback(err2, result);
                            });
                        }
                    }
                    else {
                        callback(err, res);
                    }
                }
                else {
                    logDbRead.d("Without Callback");
                }
            };
        };

        var overwriteDefaultRead = function(obj, name) {
            obj["_" + name] = obj[name];
            obj[name] = function(query, options, callback) {
                var e;
                var at = "";
                if (log.getLevel("db") === "debug" || log.getLevel("db") === "info") {
                    e = new Error();
                    at += e.stack.replace(/\r\n|\r|\n/g, "\n").split("\n")[2];
                }
                if (typeof options === "function") {
                    //options was not passed, we have callback
                    logDbRead.d(name + " " + collection + " %j" + at, query);
                    logDbRead.d("From connection %j", countlyDb._cly_debug);
                    return this["_" + name](query, logForReads(options, e, copyArguments(arguments, name)));
                }
                else {
                    if (name === "findOne" && options && !options.projection) {
                        if (options.fields) {
                            options.projection = options.fields;
                            delete options.fields;
                        }
                        else {
                            options = {projection: options};
                        }
                    }
                    //we have options
                    logDbRead.d(name + " " + collection + " %j %j" + at, query, options);
                    logDbRead.d("From connection %j", countlyDb._cly_debug);
                    return this["_" + name](query, options, logForReads(callback, e, copyArguments(arguments, name)));
                }
            };
        };

        overwriteDefaultRead(ob, "findOne");
        overwriteDefaultRead(ob, "aggregate");

        ob._find = ob.find;
        ob.find = function(query, options) {
            var e;
            var args = arguments;
            var at = "";
            //new options instead of projection
            if (options && !options.projection) {
                if (options.fields) {
                    options.projection = options.fields;
                    delete options.fields;
                }
                else {
                    options = {projection: options};
                }
            }
            if (log.getLevel("db") === "debug" || log.getLevel("db") === "info") {
                e = new Error();
                at += e.stack.replace(/\r\n|\r|\n/g, "\n").split("\n")[2];
            }
            logDbRead.d("find " + collection + " %j %j" + at, query, options);
            logDbRead.d("From connection %j", countlyDb._cly_debug);
            var cursor = this._find(query, options);
            cursor._toArray = cursor.toArray;
            cursor.toArray = function(callback) {
                cursor._toArray(logForReads(callback, e, copyArguments(args, "find")));
            };
            return cursor;
        };

        //backwards compatability

        ob._count = ob.count;
        ob.count = ob.countDocuments;
        ob.ensureIndex = ob.createIndex;

        ob.update = function(selector, document, options, callback) {
            if (options && typeof options === "object" && options.multi) {
                return ob.updateMany(selector, document, options, callback);
            }
            else {
                return ob.updateOne(selector, document, options, callback);
            }
        };

        ob.remove = function(selector, options, callback) {
            if (options && typeof options === "object" && options.single) {
                return ob.deleteOne(selector, options, callback);
            }
            else {
                return ob.deleteMany(selector, options, callback);
            }
        };

        ob.insert = function(docs, options, callback) {
            if (docs && Array.isArray(docs)) {
                return ob.insertMany(docs, options, callback);
            }
            else {
                return ob.insertOne(docs, options, callback);
            }
        };

        ob._findAndModify = function(query, sort, doc, options, callback) {
            if (options && typeof options === "object") {
                if (options.new) {
                    options.returnOriginal = false;
                }
                if (options.remove) {
                    return ob.findOneAndDelete(query, options, callback);
                }
                else {
                    return ob.findOneAndUpdate(query, doc, options, callback);
                }
            }
            return ob.findOneAndUpdate(query, doc, options, callback);
        };

        ob.findAndRemove = function(query, sort, options, callback) {
            return ob.findOneAndDelete(query, options, callback);
        };


        countlyDb._collection_cache[collection] = ob;

        //return original collection object
        return ob;
        };
        return countlyDb;
    };

   /**
   * Allow extending object module is exporting by using extend folders in countly
   * @param {string} name - filename to extend
   * @param {object} object - object to extend
   **/
   this.extendModule = function(name, object) {

   };

}


/* ************************************************************************
SINGLETON CLASS DEFINITION
************************************************************************ */
pluginManager.instance = null;

/**
 * Singleton getInstance definition
 * @returns {object} pluginManager class
 */
pluginManager.getInstance = function() {
    if (this.instance === null) {
        this.instance = new pluginManager();
        this.instance.extendModule("pluginManager", this.instance);
    }
    return this.instance;
};

module.exports = pluginManager.getInstance();
