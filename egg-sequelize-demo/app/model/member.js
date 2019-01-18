'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN } = Sequelize;

  const Member = app.model.define('member', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    username: STRING(100),//账号
    name: STRING(100),
    mobilephone: STRING(100),

    lastlogontime:DATE,
    logontimes:INTEGER,
    // created_at: { type: DATE, defaultValue: Sequelize.NOW },
    // updated_at: DATE,
    is_lock: { type: BOOLEAN, defaultValue: 0 },
  },
  {
    tableName: 'member',
    timestamps: false,
  }
  );

//   Post.associate = function() {
//     app.model.Post.belongsTo(app.model.User, { as: 'user' });
//   };

  return Member;
};
