'use strict';

const Service = require('egg').Service;

// service
class TraineeService extends Service {

    // index 查询列表，含分页、模糊查询，统一标准返回结果
    // ======================================================================================================>
    async index(payload) {

        const { app, ctx } = this;
        const sequelize = app.Sequelize;
        const Op = sequelize.Op;
        const { currentPage = 1, pageSize = 10, search, name, id_card, mobile, channel_id, tgn_type, tgn_phase, tgn_num,industry_ext,industry} = payload;
    
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

        const scid = await ctx.service.token.getScid();
        if(scid <= 0){
          return { pagination:{}, list:[] };
        }
        
        let tgnwhere={};
        if(tgn_type){
          tgnwhere={...tgnwhere,
            type:tgn_type};
        }
        if(tgn_phase){
          tgnwhere={...tgnwhere,
            phase:tgn_phase};
        }
        if(tgn_num){
          tgnwhere={...tgnwhere,
            num:tgn_num};
        }

        let include =[{model: ctx.model.TraineeGraduationNumber, as: 'tgns', where: tgnwhere },  
                      {model: ctx.model.Channel, as: 'channel', where: { kpi_subcompany: scid } },
                      ];
        let query = {include:include}; 
        
        // see http://docs.sequelizejs.com/manual/tutorial/querying.html
        let where = { is_delete: 0 };
        if (name) { // like
          where = { ...where,
             name: { [Op.like]: '%' + name + '%' },
          };
        }


        
        if (id_card) {
            where = { ...where,
             id_card: { [Op.like]: id_card + '%'},
            };
        }

        if (mobile) {
            where = {...where,
              mobile:{ [Op.like]: mobile + '%'},
            };
        }
        if (channel_id) {
          where = {
            ...where,
            channel_id: parseInt(channel_id),
          };
        }
        
    
        query = { ...query, where };
    
        res = await ctx.model.Trainee.findAll({ ...query,
          // include,
          order,
          limit,
          offset });
        totalCount = await ctx.model.Trainee.count(query);
    
        totalPages = parseInt(totalCount / limit);
        if (totalCount % limit != 0) {
          totalPages++;
        }
        pagination = { ...pagination, total:totalCount, totalPages };
    
        // console.log('res', res);
        console.log('pagination', pagination);
        const list = res.map((e, i) => {
          const jsonObject = Object.assign({}, e.dataValues);
          // jsonObject.key = i
          if (e.id_card) {
            jsonObject.id_card = e.id_card.substr(0, 3) + '***' + e.id_card.substr(e.id_card.length-3, 3);
          }else{
            jsonObject.id_card = e.id_card;
          }
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

        let include =[ {model: ctx.model.TraineeGraduationNumber, as: 'tgns' ,
                        include:[{model: ctx.model.ActivityPhase, as: 'phaseObj'},]}
                     ];

        const trainee = await ctx.model.Trainee.findByPk( _id,{include:include});
        if (!trainee) {
         ctx.throw(404, 'post not found');
        }
        // const user = await post.getUser();
        // post.setDataValue('user', user);

     return { item: trainee };
  }

  // update
  // ======================================================================================================>
  async update(_id, payload) {

    const { ctx, service } = this;
    const trainee = await ctx.model.Trainee.findByPk(_id);
    if (!trainee) {
      ctx.throw(404, 'post not found');
    }
    // console.log('payload', payload);

    // return ctx.model.Post.update(payload, { where: {id: _id}});
    // or
    return trainee.update(payload);
  }

      



}
module.exports = TraineeService;