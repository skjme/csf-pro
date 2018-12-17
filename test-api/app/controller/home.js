const Controller = require('egg').Controller;

class HomeController extends Controller {
  async index() {
    //this.ctx.body = 'Hello world';

    // this.ctx.body = [1, 2];

    this.ctx.body = {name: 'Anna', age : 4};
  }
}

module.exports = HomeController;