'use strict';

const Controller = require('egg').Controller;

class ChannelController extends Controller {

  // 构造器，
  constructor(ctx) {
    super(ctx);

    // // 定义新增验证规则
    // this.ChannelCreateTransfer = {
    //   title: { type: 'string', required: true, allowEmpty: false, min: 6 },
    // };

    // // 定义修改验证规则
    // this.ChannelUpdateTransfer = {
    //   title: { type: 'string', required: true, allowEmpty: false, min: 6 },
    //   content: { type: 'string', required: true, allowEmpty: false, min: 10 },
    // };
  }

  /**
   * 查询列表
   * method: GET
   * path: /mgr/api/channel
   */
  async index() {
    const { ctx, service } = this;
    // 组装参数
    const payload = ctx.query;
    // 调用 Service 进行业务处理
    const res = await service.channel.index(payload);
    // 设置响应内容和响应状态码
    ctx.helper.success({ ctx, res });
  }

  /**
   * 获取一条数据
   * method: GET
   * path: /mgr/api/channel/:id
   */
  async show() {

    const { ctx, service } = this;
    // 组装参数
    const { id } = ctx.params;
    // 调用 Service 进行业务处理
    const res = await service.channel.show(id);
    // 设置响应内容和响应状态码
    ctx.helper.success({ ctx, res });
  }

//   /**
//    * 新增保存
//    * method: POST
//    * path: /mgr/api/channel
//    */
//   async create() {
//     const { ctx, service } = this;
//     // 校验参数
//     ctx.validate(this.ChannelCreateTransfer);
//     // 组装参数
//     const payload = ctx.request.body || {};
//     // 调用 Service 进行业务处理
//     const res = await service.channel.create(payload);
//     // 设置响应内容和响应状态码
//     ctx.helper.success({ ctx, res });
//   }

//   /**
//    * 修改保存
//    * method: PUT
//    * path: /mgr/api/channel/:id
//    */
//   async update() {
//     const { ctx, service } = this;
//     // 校验参数
//     ctx.validate(this.ChannelUpdateTransfer);
//     // 组装参数
//     const { id } = ctx.params;
//     const payload = ctx.request.body || {};
//     // 调用 Service 进行业务处理
//     await service.channel.update(id, payload);
//     // 设置响应内容和响应状态码
//     ctx.helper.success({ ctx });
//   }

//   /**
//    * 删除数据
//    * method: DELETE
//    * path: /mgr/api/channel/:id
//    */
//   async destroy() {
//     const { ctx, service } = this;
//     // 校验参数
//     // ctx.validate(this.ChannelUpdateTransfer)
//     // 组装参数
//     const { id } = ctx.params;
//     // 调用 Service 进行业务处理
//     await service.channel.destroy(id);
//     // 设置响应内容和响应状态码
//     ctx.helper.success({ ctx });
//   }


}
module.exports = ChannelController;
