'use strict';

module.exports = app => {
  const { STRING, INTEGER, DATE } = app.Sequelize;

  const User = app.model.define('user', {
    login: STRING,
    name: STRING(30),
    password: STRING(32),
    age: INTEGER,
    last_sign_in_at: DATE,
    created_at: DATE,
    updated_at: DATE,
  });

  User.findByLogin = async (login) => {
    return await this.findOne({
      where: {
        login: login
      }
    });
  }

  User.prototype.logSignin = async () => {
    return await this.update({ last_sign_in_at: new Date() });
  }

  return User;
};