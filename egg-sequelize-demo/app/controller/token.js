const Controller = require('egg').Controller;

class TokenController extends Controller {

  // encode token
  async index() {

    const ctx = this.ctx;
    const _id = ctx.query;
    console.log('_id', _id);
    
    if(!_id.uid){
      this.ctx.status = 400;
      this.ctx.body = "Data missing, [uid].";
      return;
    }
    
    const token = await ctx.service.token.signJwt(_id);

    this.ctx.body = token;
  }

  // decode token
  async decode() {

    const ctx = this.ctx;
    const token = ctx.query.token;
    if(!token){
      this.ctx.status = 400;
      this.ctx.body = "Param error, [token].";
      return;
    }

    //console.log('token', token);
    
    const decodeResult = await ctx.service.token.decodeJwt(token);

    this.ctx.body = decodeResult;
  }

}

module.exports = TokenController;