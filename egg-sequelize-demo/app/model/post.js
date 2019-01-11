'use strict';

module.exports = app => {
  const { STRING, INTEGER, DATE } = app.Sequelize;

  const Post = app.model.define('post', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    title: STRING(100),
    content: STRING(400),
    user_id1: INTEGER,
    created_at: DATE,
    updated_at: DATE,
  });

  Post.associate = function() {
    app.model.Post.belongsTo(app.model.User, 
      { 
        as: 'user', 
        foreignKey: 'user_id1' ,
        constraints: false,
        // targetKey: 'id' // default pk
      });
  }


  return Post;
};