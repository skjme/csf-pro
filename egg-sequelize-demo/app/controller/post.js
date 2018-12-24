const Controller = require('egg').Controller;
class PostController extends Controller {

  constructor(ctx) {
    super(ctx)

    this.PostCreateTransfer = {
      title: {type: 'string', required: true, allowEmpty: false, min: 6},
     // mobile: {type: 'string', required: true, allowEmpty: false, format: /^[0-9]{11}$/},
     //  password: {type: 'password', required: true, allowEmpty: false, min: 6},
     // realName: {type: 'string', required: true, allowEmpty: false, format: /^[\u2E80-\u9FFF]{2,6}$/}
    }

    this.PostUpdateTransfer = {
      title: {type: 'string', required: true, allowEmpty: false, min: 6},
      content: {type: 'string', required: true, allowEmpty: false, min: 10},
    }
  }

  async index() {
    const { ctx, service } = this
    // 组装参数
    const payload = ctx.query
    // 调用 Service 进行业务处理
    const res = await service.post.index(payload)
    // 设置响应内容和响应状态码
    ctx.helper.success({ctx, res})
  }

  async show() {
    
    const { ctx, service } = this
    // 组装参数
    const { id } = ctx.params
    // 调用 Service 进行业务处理
    const res = await service.post.show(id)
    // 设置响应内容和响应状态码
    ctx.helper.success({ctx, res})
  }

  async create() {
    const { ctx, service } = this;
    // 校验参数
    ctx.validate(this.PostCreateTransfer)
    // 组装参数
    const payload = ctx.request.body || {}
    // 调用 Service 进行业务处理
    const res = await service.post.create(payload)
    // 设置响应内容和响应状态码
    ctx.helper.success({ctx, res})

    // verify parameters
    // ctx.validate(createRule);

    // assemble parameters
    // const author = ctx.session.userId;
    // const req = Object.assign(ctx.request.body, { author });

    // ctx.query /path?name=123
    // ctx.param /path/:id
    // ctx.request.body => body x-www-form-urlencode (postman post request)

   // console.log('req', req);
    // console.log('ctx', ctx);

    // calls Service to handle business
    //const res = await service.post.create(req);

    // set response content and status code
    // ctx.body = { id: res.id };
    // ctx.status = 201;
   // ctx.helper.success({ctx, res})
  }

    // 修改
    async update() {
      const { ctx, service } = this
      // 校验参数
      ctx.validate(this.PostUpdateTransfer)
      // 组装参数
      const { id } = ctx.params
      const payload = ctx.request.body || {}
      // 调用 Service 进行业务处理
      await service.post.update(id, payload)
      // 设置响应内容和响应状态码
      ctx.helper.success({ctx})
    }
}
module.exports = PostController;