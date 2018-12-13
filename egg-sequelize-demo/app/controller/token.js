const Controller = require('egg').Controller;

class TokenController extends Controller {

  async index() {

    const ctx = this.ctx;
    const _id = ctx.query;

    console.log('_id', _id);
    
    const token = await ctx.service.token.signJwt(_id);

    this.ctx.body = token;
  }

  async decode() {

    const ctx = this.ctx;
    const token = ctx.query.token;

    console.log('token', token);
    
    const decodeResult = await ctx.service.token.decodeJwt(token);

    this.ctx.body = decodeResult;
  }

}

module.exports = TokenController;