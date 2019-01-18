const Service = require('egg').Service;

var crypto = require('crypto');
// service
class Md5Service extends Service {

async md5Hash(content){
        var verifysign = crypto.createHash('md5').update(content, 'utf8').digest("hex");
        console.log(typeof verifysign,verifysign);
        
        //得到verifysign
        if (verifysign) {
            return verifysign;
        }
    }
}


module.exports = Md5Service;
