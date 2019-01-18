'use strict';

const Controller = require('egg').Controller;

class AdminController extends Controller {

  /**
   * 登录
   * method: post
   * path: /api/login/account
   */
  async login() {
    const { ctx, service } = this;
    // 校验参数
    // ctx.validate(this.AdminUpdateTransfer);
    // 组装参数
    // const { id } = ctx.params;
    const payload = ctx.request.body || {};
    // 调用 Service 进行业务处理

    // console.log('pppppp',payload);
    
    const res = await service.admin.login(payload);
    // 设置响应内容和响应状态码
    // ctx.helper.success({ ctx,res  });

  }

  async currentUser() {

    const { ctx, service } = this;
    // 校验参数
    // ctx.validate(this.AdminUpdateTransfer);
    // 组装参数
    const { id } = ctx.params;

    const res = await service.admin.show(id);

    const user = { name: res.item.name, userid: res.item.id, 
      avatar: 'https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png', 
      email: 'antdesign@alipay.com', 
      signature: '海纳百川，有容乃大', title: '交互专家', group: '蚂蚁金服－某某某事业群－某某平台部－某某技术部－UED', tags: [{ key: '0', label: '很有想法的' }, { key: '1', label: '专注设计' }, { key: '2', label: '辣~' }, { key: '3', label: '大长腿' }, { key: '4', label: '川妹子' }, { key: '5', label: '海纳百川' }], notifyCount: 12, country: 'China', geographic: { province: { label: '浙江省', key: '330000' }, city: { label: '杭州市', key: '330100' } }, address: '西湖区工专路 77 号', phone: '0752-268888888' };
    
    this.ctx.body = user;

  }





}
module.exports = AdminController;
