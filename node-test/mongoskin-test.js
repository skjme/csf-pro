const config = require('./config')
const plugins = require('./pluginManager')

// console.log(config);
// console.log(plugins);


/**
 * Create DB connection
 */
const db = plugins.dbConnection(config);

console.log("=============");
console.log(db);

console.log("=============");
console.log(db.collection("plugins"));

db.collection("plugins").findOne({_id: "plugins"},  function(err, res) {

    if(!err){
        console.log("=======res======");
        console.log(res);
        
    }else{
        console.log("======err=======");
        console.log("err", err);
        
    }
});

console.log("------")
