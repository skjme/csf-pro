const Service = require('egg').Service;

class PostService extends Service {

    async create(req){
        const ctx = this.ctx;
        const post = await ctx.model.Post.create(req);
        return post;
    }
    
}

module.exports = PostService;