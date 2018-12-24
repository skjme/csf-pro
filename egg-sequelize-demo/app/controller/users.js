const Controller = require('egg').Controller;

class UserController extends Controller {

  // 获取所有用户(分页/模糊) /users?name=na&age=18&pageSize=10&currentPage=1
  async index() {
    const { ctx, service } = this
    // 组装参数
    const payload = ctx.query
    // 调用 Service 进行业务处理
    const res = await service.user.index(payload)
    // 设置响应内容和响应状态码
    ctx.helper.success({ctx, res})
  }

  async index_bak() {
    // const { app, ctx, service, logger } = this;

    // // const ctx = this.ctx;
    // const sequelize = app.Sequelize;
    // const Op = sequelize.Op;

    // const queryCount = {
    //   attributes: [[sequelize.fn('COUNT', sequelize.col('age')), 'no_age']],
    //   limit: toInt(ctx.query.limit),
    //   offset: toInt(ctx.query.offset)
    // };
    // await ctx.model.User.findAll(queryCount);

    // const query = {
    //   attributes: ['id', 'name', 'age', ['age', 'userAge']],
    //   limit: toInt(ctx.query.limit),
    //   offset: toInt(ctx.query.offset),
    //   where: {
    //     [Op.or]: [{id: 1}, {id: 2}]
    //   }
    // };

    // remove attributes
    // const query = {
    //   attributes: {exclude: ['created_at']},
    //   limit: toInt(ctx.query.limit),
    //   offset: toInt(ctx.query.offset)
    // };

    // add attributes
    // const query = {
    //   attributes: {include:[[sequelize.fn('COUNT', sequelize.col('age')), 'no_age']]},
    //   limit: toInt(ctx.query.limit),
    //   offset: toInt(ctx.query.offset)
    // };

    //ctx.body = await ctx.model.User.findAll(query);

  }

  async show() {
    const ctx = this.ctx;
    // ctx.body = await ctx.model.User.findById(toInt(ctx.params.id));
    ctx.body = await ctx.model.User.findByPk(Number(ctx.params.id)) || {};
  }

  async create() {
    const ctx = this.ctx;
    const {
      name,
      age
    } = ctx.request.body;
    const user = await ctx.model.User.create({
      name,
      age
    });
    ctx.status = 201;
    ctx.body = user;
  }

  async update() {
    const ctx = this.ctx;
    const id = toInt(ctx.params.id);
    const user = await ctx.model.User.findById(id);
    if (!user) {
      ctx.status = 404;
      return;
    }

    const {
      name,
      age
    } = ctx.request.body;
    await user.update({
      name,
      age
    });
    ctx.body = user;
  }

  async destroy() {
    const ctx = this.ctx;
    const id = toInt(ctx.params.id);
    const user = await ctx.model.User.findById(id);
    if (!user) {
      ctx.status = 404;
      return;
    }

    await user.destroy();
    ctx.status = 200;
  }
}

module.exports = UserController;