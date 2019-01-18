const Service = require('egg').Service;

// service
class PostService extends Service {

  // index 查询列表，含分页、模糊查询，统一标准返回结果
  // ======================================================================================================>
  async index(payload) {

    const { app, ctx } = this;
    const sequelize = app.Sequelize;
    const Op = sequelize.Op;
    const { currentPage = 1, pageSize = 10, search, title, status } = payload;

    // res 数据集合
    let res = [];
    // 分页
    let totalCount = 0; // 总记录数
    let totalPages = 0; // 总页数
    const limit = Number(pageSize || 10);
    const offset = ((Number(currentPage)) - 1) * limit;
    let pagination = {
      pageSize: Number(pageSize),
      currentPage: Number(currentPage),
    };
    // 排序
    const order = [[ 'id', 'DESC' ]];
    // 查询条件
    let query = {};
    // see http://docs.sequelizejs.com/manual/tutorial/querying.html
    let where = { is_delete: 0 };
    if (title) { // like
      where = { ...where,
        title: { [Op.like]: '%' + title + '%' },
      };
    }
    if (status) { // =
      where = { ...where, status };
    }

    query = { ...query, where };

    res = await ctx.model.Post.findAll({ ...query,
      order,
      limit,
      offset });
    totalCount = await ctx.model.Post.count(query);

    totalPages = parseInt(totalCount / limit);
    if (totalCount % limit != 0) {
      totalPages++;
    }
    pagination = { ...pagination, totalCount, totalPages };

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
    return { pagination, list };
  }

  // show
  // ======================================================================================================>
  async show(_id) {

    const { ctx } = this;

    const post = await ctx.model.Post.findByPk(_id);
    if (!post) {
      ctx.throw(404, 'post not found');
    }
    const user = await post.getUser();
    post.setDataValue('user', user);

    return { item: post };
  }

  // create
  // ======================================================================================================>
  async create(req) {
    const ctx = this.ctx;
    const post = await ctx.model.Post.create(req);
    return post;
  }

  // update
  // ======================================================================================================>
  async update(_id, payload) {
    const { ctx, service } = this;
    const post = await ctx.model.Post.findByPk(_id);
    if (!post) {
      ctx.throw(404, 'post not found');
    }
    // console.log('payload', payload);

    // return ctx.model.Post.update(payload, { where: {id: _id}});
    // or
    return post.update(payload);
  }

  // destroy 删除
  // ======================================================================================================>
  async destroy(_id) {
    const { ctx, service } = this;
    const post = await ctx.model.Post.findByPk(_id);
    if (!post) {
      ctx.throw(404, 'post not found');
    }

    return ctx.model.Post.update({ is_delete: 1 }, { where: { id: _id } });
  }


}

module.exports = PostService;
