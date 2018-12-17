const Controller = require('egg').Controller;

function toInt(str) {
  if (typeof str === 'number') return str;
  if (!str) return str;
  return parseInt(str, 10) || 0;
}

class UserController extends Controller {

  // GET /api/v1/users
  async index() {
    const ctx = this.ctx;
    const query = { limit: toInt(ctx.query.limit), offset: toInt(ctx.query.offset) };
    ctx.body = await ctx.model.User.findAll(query);
  }

  // GET /api/v1/users/:id
  async show() {
    console.log('--show---');
    const ctx = this.ctx;
    ctx.body = await ctx.model.User.findById(toInt(ctx.params.id));
  }

  // GET /api/v1/users/new
  async new() {
    console.log('--new---');
    
    const ctx = this.ctx;
    ctx.body = "new";
    //ctx.body = await ctx.model.User.findById(toInt(ctx.params.id));
  }

  // GET /api/v1/users/:id/edit
  async edit() {
    console.log('--edit---');
    const ctx = this.ctx;
    ctx.body = await ctx.model.User.findById(toInt(ctx.params.id));
  }

  // POST /api/v1/users
  async create() {
    const ctx = this.ctx;
    const { name, age } = ctx.request.body;
    const user = await ctx.model.User.create({ name, age });
    ctx.status = 201;
    ctx.body = user;
  }

   // PUT /api/v1/users/:id
  async update() {
    const ctx = this.ctx;
    const id = toInt(ctx.params.id);
    const user = await ctx.model.User.findById(id);
    if (!user) {
      ctx.status = 404;
      return;
    }

    const { name, age } = ctx.request.body;
    await user.update({ name, age });
    ctx.body = user;
  }

   // DELETE /api/v1/users/:id
   // curl -X DELETE http://localhost:7001/api/v1/users/1
  async destroy() {
    console.log("destroy");
    
    const ctx = this.ctx;
    const id = toInt(ctx.params.id);
    const user = await ctx.model.User.findById(id);
    if (!user) {
      ctx.status = 404;
      return;
    }

    //await user.destroy();
    ctx.status = 200;
  }
}

module.exports = UserController;