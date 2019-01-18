'use strict';

const Service = require('egg').Service;
var crypto = require('crypto');

// service
class AdminService extends Service {

   // show
  // ======================================================================================================>
  async show(_id) {

    const { ctx } = this;

    const admin = await ctx.model.Admin.findByPk(_id);
    if (!admin) {
      ctx.throw(404, 'admin not found');
    }
   

    return { item: admin };
  }

    // login
    // ======================================================================================================>
    async login(data) {
        const { ctx } = this;
        const Op = this.app.Sequelize.Op

        let dataInfo = {};
        const admin = await ctx.model.Admin.findOne({
            where: { username: data.userName, 
                subcompany_id:{ [Op.gt]:0 } }
        });

        if (!admin) {
            let res = {
                token:'', 
                uid:0, 
                scid: 0,
                type: 'account',
                currentAuthority: '',
            }
            ctx.helper.failure({ ctx,res, message: '账号不存在' });

        } else {
            let pwd = data.password;
            let sign = await ctx.service.md5.md5Hash(pwd);
            if (sign.toUpperCase() == admin.pwd) { 

                const user = {
                    userid:admin.id,
                    username:admin.username,
                    name:admin.name,
                    subcompany_id:admin.subcompany_id,
                 };

                //获取token
                let appid = '6113107229';
                let uid = admin.id;
                let scid = admin.subcompany_id || 0;
                const tokenInfo ={appid:appid, uid:uid, scid:scid}
                let token = await ctx.service.token.signJwt(tokenInfo);
                
                 let res ={
                    token:token, 
                    uid: user.userid, 
                    scid: user.subcompany_id,
                    user: user,
                    status: 'ok',
                    type: 'account',
                    currentAuthority: 'admin',
                }

                ctx.helper.success({ ctx, res });
            } else {
                let res = {
                    token:'', 
                    uid:0, 
                    scid: 0,
                    type: 'account',
                    currentAuthority: '',
                }
                ctx.helper.failure({ ctx,res, message: '密码错误' });
            }
        }

    }
}




module.exports = AdminService;
