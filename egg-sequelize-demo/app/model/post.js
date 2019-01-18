'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN } = Sequelize;

  const Post = app.model.define('post', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    title: STRING(100),
    content: STRING(400),
    user_id: INTEGER,
    created_at: { type: DATE, defaultValue: Sequelize.NOW },
    updated_at: DATE,
    is_delete: { type: BOOLEAN, defaultValue: 0 },
  },
  {
    tableName: 'demo_posts',
  }
  );

  Post.associate = function() {
    app.model.Post.belongsTo(app.model.User, { as: 'user' });
  };


  return Post;
};
