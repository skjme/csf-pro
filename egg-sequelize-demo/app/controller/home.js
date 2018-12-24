const Controller = require('egg').Controller;

class HomeController extends Controller {
    async index() {
      this.ctx.body = '<h3>Hello, Egg + Sequelize + MySQL</h3>';
    }
  }
  
  module.exports = HomeController;