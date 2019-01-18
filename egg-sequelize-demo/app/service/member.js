'use strict';

const Service = require('egg').Service;

// service
class MemberService extends Service {

  // index 查询列表，含分页、模糊查询，统一标准返回结果
  // ======================================================================================================>
  async index(payload) {

    const { app, ctx } = this;
    const sequelize = app.Sequelize;
    const Op = sequelize.Op;
    const { currentPage = 1, pageSize = 10,  username ,mobilephone, } = payload;

    // res 数据集合
    let res = [];
    // 分页
    let total = 0; // 总记录数
    let totalPages = 0; // 总页数
    const limit = Number(pageSize || 10);
    const offset = ((Number(currentPage)) - 1) * limit;
    let pagination = {
      pageSize: Number(pageSize),
      currentPage: Number(currentPage),
    };

    // 排序
    const order = [['id', 'DESC']];
    // 查询条件
    let query = {};
    // see http://docs.sequelizejs.com/manual/tutorial/querying.html

    // const scid = await ctx.service.token.getScid();
    // if(scid <= 0){
    //   return {pagination:{}, list:[], totalInfo:{}};
    // }
    // kpi_subcompany: scid
    let where = { is_lock: 0, };


    if(username==undefined && mobilephone==undefined){
        return {pagination:{}, list:[]};
    }

    if (username) { 
        where = {
          ...where,
          username: username,
        };
      }

    if (mobilephone) {
      where = {
        ...where,
        mobilephone: mobilephone
      };
    }


    query = { ...query, where };

    res = await ctx.model.Member.findAll({
      ...query,
      order,
      limit,
      offset
    });
    total = await ctx.model.Member.count(query);
    console.log('ttttt', total, query);

    totalPages = parseInt(total / limit);
    if (total % limit != 0) {
      totalPages++;
    }
    pagination = { ...pagination, total, totalPages };

    // console.log('res', res);
    console.log('pagination', pagination);
    const list = res.map((e, i) => {
      const jsonObject = Object.assign({}, e.dataValues);
    //   // jsonObject.key = i
      jsonObject.lastlogontime = this.ctx.helper.formatTime(e.lastlogontime);
    //   jsonObject.updated_at = this.ctx.helper.formatTime(e.updated_at);
      return jsonObject;
    });

    // 统一返回值
    return { pagination, list };
  }

  // show
  // ======================================================================================================>
  async show(_id) {

    const { ctx } = this;

    const member = await ctx.model.Member.findByPk(_id);
    if (!member) {
      ctx.throw(404, 'member not found');
    }
    const user = await member.getUser();
    member.setDataValue('user', user);

    return { item: member };
  }

  //   // create
  //   // ======================================================================================================>
  //   async create(req) {
  //     const ctx = this.ctx;
  //     const member = await ctx.model.Member.create(req);
  //     return member;
  //   }

  //   // update
  //   // ======================================================================================================>
  //   async update(_id, payload) {
  //     const { ctx, service } = this;
  //     const member = await ctx.model.Member.findByPk(_id);
  //     if (!member) {
  //       ctx.throw(404, 'member not found');
  //     }
  //     // console.log('payload', payload);

  //     // return ctx.model.Member.update(payload, { where: {id: _id}});
  //     // or
  //     return member.update(payload);
  //   }

  //   // destroy 删除
  //   // ======================================================================================================>
  //   async destroy(_id) {
  //     const { ctx, service } = this;
  //     const member = await ctx.model.Member.findByPk(_id);
  //     if (!member) {
  //       ctx.throw(404, 'member not found');
  //     }

  //     return ctx.model.Member.update({ is_delete: 1 }, { where: { id: _id } });
  //   }


}

module.exports = MemberService;
