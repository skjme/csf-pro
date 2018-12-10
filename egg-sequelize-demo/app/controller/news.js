const Controller = require('egg').Controller;

class NewsController extends Controller {

  // async slist() {
  //   const dataList = {
  //     list: [
  //       { id: 1, title: 'this is news 1', url: '/news/1' },
  //       { id: 2, title: 'this is news 2', url: '/news/2' }
  //     ]
  //   };
  //   //await this.ctx.render('news/list.tpl', dataList);
  //   this.ctx.body = dataList;
  // }

  async list() {
    const ctx = this.ctx;
    const page = ctx.query.page || 1;
    const newsList = await ctx.service.news.list(page);
   // await ctx.render('news/list.tpl', { list: newsList });
    this.ctx.body = newsList;
  }

  async detail() {

    const ctx = this.ctx;
    const page = ctx.query.page || 1;
    const newsList = await ctx.service.news.list(page);
   // await ctx.render('news/list.tpl', { list: newsList });
    this.ctx.body = newsList;

    //path/:id
    console.log('ctx.params.id', ctx.params.id);
     //?page=1
    console.log('ctx.query.page', ctx.query.page);
  }
}

module.exports = NewsController;