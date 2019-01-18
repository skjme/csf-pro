'use strict';

const Service = require('egg').Service;

// service
class ActivityPhaseService extends Service {

    // getPhase
    // ======================================================================================================>

    async getPhase(payload) {

        const { app, ctx } = this;
        const sequelize = app.Sequelize;
        const Op = sequelize.Op;

        const { id,name, ext1, ext3, ext4,orderby} = payload;

        // res 数据集合
        let res = [];
        // 排序 
        const order = [[ 'orderby',], [{model: ctx.model.ActivityPhase, 
            as: 'children', }, 'orderby']];
        // let childrenwhere={ deleted:0};
        let attributes=[['id', 'key'], ['name', 'title'], ['ext1', 'value']];
        let attributes1=[['id', 'key'], ['name', 'title'], ['id', 'value']];

        let include =[{model: ctx.model.ActivityPhase, 
            as: 'children', 
            // where: childrenwhere, 
            attributes:attributes},
                      ];
        let query = {include:include,
            attributes: attributes1}; 
        
        // 查询条件

        res = await ctx.model.ActivitySeries.findAll({...query,
            order,});


        const list = res.map((e, i) => {
        const jsonObject = Object.assign({}, e.dataValues);
            // jsonObject.key = i
            jsonObject.key = i+ '-';
            jsonObject.value = i+ '-';

            jsonObject.disabled = true;
            // jsonObject.updated_at = this.ctx.helper.formatTime(e.updated_at);
            return jsonObject;
        });

        // 统一返回值
        return { list };


    }


    // getNum
    // ======================================================================================================>

    async getNum(payload) {

        const { app, ctx } = this;
        const sequelize = app.Sequelize;
        const Op = sequelize.Op;

        const { title, phase, num} = payload;

        // res 数据集合
        let res = [];
        // 排序 
        const order = [[ 'num','DESC']];
        let actNumwhere={ is_delete:0, phase:payload.phase};
        // let attributes=[['id', 'key'],['name', 'title'],['ext1','value']];
        // let attributes1=[['id', 'key'],['name', 'title'],['id','value']];

        if(phase==undefined){
            return {list:[]};
        }

        let include =[{model: ctx.model.Province, as: 'cityObj'},
                      ];
        let query = {include: include, where: actNumwhere,}; 
        
        // 查询条件

        res = await ctx.model.Activity.findAll({...query,order
          });


        const list = res.map((e, i) => {
        const jsonObject = Object.assign({}, e.dataValues);
            // jsonObject.key = i
            // jsonObject.id_card = e.id_card.substr(0, 3) + '***' + e.id_card.substr(e.id_card.length-3, 3);
            // jsonObject.updated_at = this.ctx.helper.formatTime(e.updated_at);
            if(e.cityObj){
                jsonObject.num_name=e.num + '期' + '(' + e.cityObj.title + ')';
            }else{
                jsonObject.num_name=e.num + '期';
            }
            
            return jsonObject;
        });

        // 统一返回值
        return { list };


    }

    // getProvince
    // ======================================================================================================>

    async getProvince(payload) {

        const { app, ctx } = this;
        const sequelize = app.Sequelize;
        const Op = sequelize.Op;

        const { title, parent_id, order_by} = payload;

        // res 数据集合
        let res = [];
        // 排序 
        const order = [[ 'order_by',]];

        let Provincewhere={ parent_id:payload.parent_id,};


        let include =[ {model: ctx.model.Province, as: 'children' ,
                        include:[{model: ctx.model.Province, as: 'children'},]}
                     ];
        
        // 查询条件

        res = await ctx.model.Province.findAll({order, where:Provincewhere, include:include
          });


        const list = res.map((e, i) => {
        const jsonObject = Object.assign({}, e.dataValues);
            return jsonObject;
        });

        // 统一返回值
        return { list };


    }

    // getIndustry
    // ======================================================================================================>

    async getIndustry(payload) {

        const { app, ctx } = this;
        const sequelize = app.Sequelize;
        const Op = sequelize.Op;

        const { name, parent_id, orderby} = payload;

        // res 数据集合
        let res = [];
        // 排序 
        const order = [[ 'orderby',]];
        
        // 查询条件

        // let attributes=[['id', 'value'], ['name', 'label'], ['orderby', 'orderby'], ['parent_id', 'parent_id']];

        let Industrywhere={ parent_id:payload.parent_id,};

        let include =[{model: ctx.model.Datadictionary, 
            as: 'children', 
            // attributes:attributes,
            // where:Industrywhere,
        },];

        let query = {include:include,}; 

        res = await ctx.model.Datadictionary.findAll({...query, 
            order,
            where:Industrywhere, 
            // attributes:attributes,
          });


        const list = res.map((e, i) => {
        const jsonObject = Object.assign({}, e.dataValues);
            return jsonObject;
        });

        // 统一返回值
        return { list };


    }

    

}
module.exports = ActivityPhaseService;