'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN } = Sequelize;

  const Admin = app.model.define('admin', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    username: STRING(100),//账号
    name: STRING(100),
    pwd:STRING(32),
    subcompany_id:INTEGER(11),
    
    // created_at: { type: DATE, defaultValue: Sequelize.NOW },
    // updated_at: DATE,
    // is_delete: { type: BOOLEAN, defaultValue: 0 },
  },
  {
    tableName: 'admin',
    timestamps: false,
  }
  );

//   Post.associate = function() {
//     app.model.Post.belongsTo(app.model.User, { as: 'user' });
//   };

  return Admin;
};
