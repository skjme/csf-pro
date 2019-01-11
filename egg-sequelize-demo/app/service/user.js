const Service = require('egg').Service;

class UserService extends Service {

   // index======================================================================================================>
  async index(payload) {

    const { app, ctx } = this;
    const sequelize = app.Sequelize;
    const Op = sequelize.Op;
    const { currentPage = 1, pageSize = 10, search, name, age } = payload;

    let res = [];
    let count = 0;
    let limit =  Number(pageSize || 10);
    let offset = ((Number(currentPage)) - 1) * limit;

    // see http://docs.sequelizejs.com/manual/tutorial/querying.html
    let query = {
        //attributes: [ 'id', 'name', 'age' ],
        include: { model: ctx.model.Post, as: 'posts' },
        // limit: limit,
        // offset: offset,
        // where: { 
        //      [Op.or]: [{id: 1}, {id: 2}]
        // },
        order: [ 'name', ['id', 'DESC'] ]
    };
    let where = {};
    if(name){ // like
        where = {...where, 
            name: {[Op.like]: '%'+name+'%'} 
        };
    }
    if(age){ // =
        where = {...where, age}
    }
    query = {...query, where}

    res = await ctx.model.User.findAll({...query, 
                                        limit, 
                                        offset});
    count = await ctx.model.User.count(query);
  
    //console.log('res', res);
    
    // 整理数据源 -> Ant Design Pro
    let data = res.map((e,i) => {
    //    console.log(e.dataValues);
      const jsonObject = Object.assign({}, e.dataValues)
      //jsonObject.key = i
      jsonObject.created_at = this.ctx.helper.formatTime(e.created_at)
      jsonObject.updated_at = this.ctx.helper.formatTime(e.updated_at)
      return jsonObject
    });

    return { count: count, list: data, pageSize: Number(pageSize), currentPage: Number(currentPage) };
  } 
    
}

module.exports = UserService;