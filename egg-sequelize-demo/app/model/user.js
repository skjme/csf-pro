'use strict';

module.exports = app => {
  const { STRING, INTEGER, DATE } = app.Sequelize;

  const User = app.model.define('user', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    name: STRING(30),
    age: INTEGER,
    created_at: DATE,
    updated_at: DATE,
  });

  // one to many
  User.associate = function() {
    app.model.User.hasMany(app.model.Post, { as: 'posts', foreignKey: 'user_id1',
    constraints: false,
    scope:{
      is_delete: 0
    } });
  }

  return User;
};