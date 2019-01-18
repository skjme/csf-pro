'use strict';

const Controller = require('egg').Controller;

class AactivityPhaseController extends Controller {

//     // 构造器，
//   constructor(ctx) {
//     super(ctx);

//     // 定义新增验证规则
//     this.PostCreateTransfer = {
//       title: { type: 'string', required: true, allowEmpty: false, min: 6 },
//     };

//     // 定义修改验证规则
//     this.PostUpdateTransfer = {
//       title: { type: 'string', required: true, allowEmpty: false, min: 6 },
//       content: { type: 'string', required: true, allowEmpty: false, min: 10 },
//     };
//   }

/**
   * 查询Phase
   * method: GET
   * path: /mgr/api/activityphase/getPhase
   */
  async getPhase() {
    const { ctx, service } = this;
    // 组装参数
    const payload = ctx.query;
    // 调用 Service 进行业务处理
    const res = await service.activityphase.getPhase(payload);
    // 设置响应内容和响应状态码
    ctx.helper.success({ ctx, res });
  }

  /**
   * 查询Num
   * method: GET
   * path: /mgr/api/activityphase/getNum
   */
  async getNum() {
    const { ctx, service } = this;
    // 组装参数
    const payload = ctx.query;
    // 调用 Service 进行业务处理
    const res = await service.activityphase.getNum(payload);
    // 设置响应内容和响应状态码
    ctx.helper.success({ ctx, res });
  }

  /**
   * 查询Province
   * method: GET
   * path: /mgr/api/activityphase/getProvince
   */
  async getProvince() {
    const { ctx, service } = this;
    // 组装参数
    const payload = ctx.query;
    // 调用 Service 进行业务处理
    const res = await service.activityphase.getProvince(payload);
    // 设置响应内容和响应状态码
    ctx.helper.success({ ctx, res });
  }

  /**
   * 查询industry
   * method: GET
   * path: /mgr/api/activityphase/getIndustry
   */
  async getIndustry() {
    const { ctx, service } = this;
    // 组装参数
    const payload = ctx.query;
    // 调用 Service 进行业务处理
    const res = await service.activityphase.getIndustry(payload);
    // 设置响应内容和响应状态码
    ctx.helper.success({ ctx, res });
  }

//   /**
//    * 获取一条数据
//    * method: GET
//    * path: /mgr/api/trainee/:id
//    */
//   async show() {
    
//     const { ctx, service } = this
//     // 组装参数
//     const { id } = ctx.params
//     // 调用 Service 进行业务处理
//     const res = await service.trainee.show(id)
//     // 设置响应内容和响应状态码
//     ctx.helper.success({ctx, res})
//   }



  

}
module.exports = AactivityPhaseController;
