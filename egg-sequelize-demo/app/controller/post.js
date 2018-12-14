const Controller = require('egg').Controller;
class PostController extends Controller {

  async create() {
    const { ctx, service } = this;
    const createRule = {
      title: { type: 'string' },
      content: { type: 'string' },
    };

    // verify parameters
    // ctx.validate(createRule);

    // assemble parameters
    const author = ctx.session.userId;
    const req = Object.assign(ctx.request.body, { author });

    // ctx.query /path?name=123
    // ctx.param /path/:id
    // ctx.request.body => body x-www-form-urlencode (postman post request)

    console.log('req', req);
    // console.log('ctx', ctx);

    // calls Service to handle business
    const res = await service.post.create(req);

    // set response content and status code
    ctx.body = { id: res.id };
    ctx.status = 201;
  }
}
module.exports = PostController;