'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN } = Sequelize;

  const Channel = app.model.define('channel', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    username: STRING(100),//账号
    name: STRING(100),
    mobilephone: STRING(100),
    owner: STRING(80),//负责人
    
    grade:STRING(10),//级别 102401

    validity:{ type: BOOLEAN, defaultValue: 1 },//是否有效：1正式 0离职
    is_ambassador_xy:{ type: BOOLEAN, defaultValue: 1 },//宣扬大使
    is_partner:{ type: BOOLEAN, defaultValue: 1 },//事业合伙人
    is_career:{ type: BOOLEAN, defaultValue: 1 },//城市合伙人

    
    created_at: { type: DATE, defaultValue: Sequelize.NOW },
    updated_at: DATE,
    is_delete: { type: BOOLEAN, defaultValue: 0 },
  },
  {
    tableName: 'channel',
  }
  );

//   Post.associate = function() {
//     app.model.Post.belongsTo(app.model.User, { as: 'user' });
//   };

  return Channel;
};
