'use strict';

const Service = require('egg').Service;

// service
class ChannelService extends Service {

  // index 查询列表，含分页、模糊查询，统一标准返回结果
  // ======================================================================================================>
  async index(payload) {

    const { app, ctx } = this;
    const sequelize = app.Sequelize;
    const Op = sequelize.Op;
    const { currentPage = 1, pageSize = 10, search, username, name,mobilephone, grade, is_ambassador_xy, is_partner, is_career, status, id } = payload;

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

    const scid = await ctx.service.token.getScid();
    if(scid <= 0){
      return {pagination:{}, list:[], totalInfo:{}};
    }
    let where = { is_delete: 0, validity: 1, kpi_subcompany: scid };

    //筛选条件
    let where1 = {
      ...where,
      grade: 102401,
    }

    let where2 = {
      ...where,
      is_ambassador_xy: 1,
    }

    let where3 = {
      ...where,
      is_partner: 1,
    }

    let where4 = {
      ...where,
      is_career: 1,
    }

    let all_count = await ctx.model.Channel.count({ where: where });
    let elder_count = await ctx.model.Channel.count({ where: where1 });
    let xy_count = await ctx.model.Channel.count({ where: where2 });
    let partner_count = await ctx.model.Channel.count({ where: where3 });
    let career_count = await ctx.model.Channel.count({ where: where4 });

    let totalInfo = {
      all_count: all_count,
      elder_count: elder_count,
      xy_count: xy_count,
      partner_count: partner_count,
      career_count: career_count
    };

    if (username) { 
      where = {
        ...where,
        username: username,
      };
    }

    if (id) { // like
      where = {
        ...where,
        id: id,
      };
    }

    if (name) { // like
      where = {
        ...where,
        name: { [Op.like]: '%' + name + '%' },
      };
    }

    if (mobilephone) {
      where = {
        ...where,
        mobilephone: { [Op.like]: '%' + mobilephone + '%' },
      };
    }

    if (is_ambassador_xy) {
      where = {
        ...where,
        is_ambassador_xy: parseInt(is_ambassador_xy),
      };
    }

    if (is_partner) {
      where = {
        ...where,
        is_partner: parseInt(is_partner),
      };
    }

    if (is_career) {
      where = {
        ...where,
        is_career: parseInt(is_career),
      };
    }

    if (grade) {
      if (grade == '1') {
        where = {
          ...where,
          grade: '102401',
        };
      } else {
        where = {
          ...where,
          grade: { [Op.ne]: '102401' }
        };
      }

    }


    if (status) { // =
      where = { ...where, status };
    }

    query = { ...query, where };

    res = await ctx.model.Channel.findAll({
      ...query,
      order,
      limit,
      offset
    });
    total = await ctx.model.Channel.count(query);
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
      // jsonObject.key = i
      jsonObject.created_at = this.ctx.helper.formatTime(e.created_at);
      jsonObject.updated_at = this.ctx.helper.formatTime(e.updated_at);
      return jsonObject;
    });

    // 统一返回值
    return { pagination, list, totalInfo };
  }

  // show
  // ======================================================================================================>
  async show(_id) {

    const { ctx } = this;

    const channel = await ctx.model.Channel.findByPk(_id);
    if (!channel) {
      ctx.throw(404, 'channel not found');
    }
    const user = await channel.getUser();
    channel.setDataValue('user', user);

    return { item: channel };
  }

  //   // create
  //   // ======================================================================================================>
  //   async create(req) {
  //     const ctx = this.ctx;
  //     const channel = await ctx.model.Channel.create(req);
  //     return channel;
  //   }

  //   // update
  //   // ======================================================================================================>
  //   async update(_id, payload) {
  //     const { ctx, service } = this;
  //     const channel = await ctx.model.Channel.findByPk(_id);
  //     if (!channel) {
  //       ctx.throw(404, 'channel not found');
  //     }
  //     // console.log('payload', payload);

  //     // return ctx.model.Channel.update(payload, { where: {id: _id}});
  //     // or
  //     return channel.update(payload);
  //   }

  //   // destroy 删除
  //   // ======================================================================================================>
  //   async destroy(_id) {
  //     const { ctx, service } = this;
  //     const channel = await ctx.model.Channel.findByPk(_id);
  //     if (!channel) {
  //       ctx.throw(404, 'channel not found');
  //     }

  //     return ctx.model.Channel.update({ is_delete: 1 }, { where: { id: _id } });
  //   }


}

module.exports = ChannelService;
