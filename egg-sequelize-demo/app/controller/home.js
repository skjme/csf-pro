const Controller = require('egg').Controller;

class HomeController extends Controller {
    async index() {
      this.ctx.body = '<h1>Hello, Egg + Sequelize + MySQL</h1>';
    }
  }
  
  module.exports = HomeController;