'use strict';

module.exports = app => {
  const { STRING, INTEGER, DATE } = app.Sequelize;

  const Post = app.model.define('post', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    title: STRING(100),
    content: STRING(400),
    created_at: DATE,
    updated_at: DATE,
  });

  return Post;
};