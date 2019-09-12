var async = require("async");
const fs = require('fs');

var obj = {dev: "/configs/dev.json", test: "/configs/test.json", prod: "/configs/prod.json"};
var configs = {};

async.forEachOf(obj, (value, key, callback) => {
    fs.readFile(__dirname + value, "utf8", (err, data) => {
        if (err) return callback(err);
        try {
            configs[key] = JSON.parse(data);
        } catch (e) {
            return callback(e);
        }
        callback();
    });
}, err => {
    if (err) console.error(err.message);
    // configs is now a map of JSON data
    doSomethingWith(configs);
});

function doSomethingWith(configs){
    console.log("=========");
    console.log(configs);
    
}