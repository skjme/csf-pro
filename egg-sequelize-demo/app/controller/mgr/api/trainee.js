'use strict';

const Controller = require('egg').Controller;

class TraineeController extends Controller {

//     // 构造器，
  constructor(ctx) {
    super(ctx);

//     // 定义新增验证规则
//     this.PostCreateTransfer = {
//       title: { type: 'string', required: true, allowEmpty: false, min: 6 },
//     };

    // 定义修改验证规则
    this.PostUpdateTransfer = {
      // title: { type: 'string', required: true, allowEmpty: false, min: 6 },
      // content: { type: 'string', required: true, allowEmpty: false, min: 10 },
    };
  }

/**
   * 查询列表
   * method: GET
   * path: /mgr/api/trainee
   */
  async index() {
    const { ctx, service } = this;
    // 组装参数
    const payload = ctx.query;
    // 调用 Service 进行业务处理
    const res = await service.trainee.index(payload);
    // 设置响应内容和响应状态码
    ctx.helper.success({ ctx, res });
  }

  /**
   * 获取一条数据
   * method: GET
   * path: /mgr/api/trainee/:id
   */
  async show() {
    
    const { ctx, service } = this
    // 组装参数
    const { id } = ctx.params
    // 调用 Service 进行业务处理
    const res = await service.trainee.show(id)
    // 设置响应内容和响应状态码
    ctx.helper.success({ctx, res})
  }

  /**
   * 修改保存
   * method: PUT
   * path: /mgr/api/trainee/:id
   */
  async update() {
    const { ctx, service } = this;
    // 校验参数
    ctx.validate(this.PostUpdateTransfer);
    // 组装参数
    const { id } = ctx.params;
    const payload = ctx.request.body || {};
    // 调用 Service 进行业务处理
    await service.trainee.update(id, payload);
    // 设置响应内容和响应状态码
    ctx.helper.success({ ctx });
  }



  

}
module.exports = TraineeController;
