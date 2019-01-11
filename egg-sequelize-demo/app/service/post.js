const Service = require('egg').Service;

class PostService extends Service {

    async index(payload) {

        const { app, ctx } = this;
       // const sequelize = app.Sequelize;

        const posts = await ctx.model.Post.findAll({
            attributes: [ 'id', 'user_id1' ],
            include: { model: ctx.model.User, as: 'user', foreignKey: 'user_id1', constraints: false },
            where: { status: 'publish' },
            order: [['id', 'DESC']],
          });

        // return posts;
        return { list: posts };
    }

    // show======================================================================================================>
    async show(_id) {

        const { ctx } = this;

        const post = await ctx.model.Post.findByPk(_id);
        if (!post) {
            ctx.throw(404, 'post not found')
          }
        const user = await post.getUser();
        post.setDataValue('user', user);

        return { item: post };
    }

    // create======================================================================================================>
    async create(req){
        const ctx = this.ctx;
        const post = await ctx.model.Post.create(req);
        return post;
    }

   // update======================================================================================================>
   async update(_id, payload) {
    const { ctx, service } = this
    const post = await ctx.model.Post.findByPk(_id);
    if (!post) {
      ctx.throw(404, 'post not found')
    }
    console.log('payload', payload);
    
    //return ctx.model.Post.update(payload, { where: {id: _id}});
    // or
    return post.update(payload);
  }

    
}

module.exports = PostService;