const Service = require('egg').Service;
const jwt = require('jsonwebtoken');

const SECRET_KEY = "ADFADSFDASFDASGDASGADSFADSSFDASGFASG";

class TokenService extends Service {
    
    async signJwt(_id){
        return jwt.sign({
            data:{
                _id,
            },
            exp: Math.floor(Date.now() / 1000) + (60 * 60 * 24 * 7),
        }, SECRET_KEY);
    }

    async decodeJwt(token){
        try{
            return jwt.verify(token, SECRET_KEY);
        } catch(err){
            return err;
        }
    }
}

module.exports = TokenService;