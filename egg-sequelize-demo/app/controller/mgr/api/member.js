'use strict';

const Controller = require('egg').Controller;

class MemberController extends Controller {

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
   * path: /mgr/api/member
   */
  async index() {
    const { ctx, service } = this;
    // 组装参数
    const payload = ctx.query;
    // 调用 Service 进行业务处理
    const res = await service.member.index(payload);
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
    const res = await service.member.show(id);
    // 设置响应内容和响应状态码
    ctx.helper.success({ ctx, res });
  }


}
module.exports = MemberController;
