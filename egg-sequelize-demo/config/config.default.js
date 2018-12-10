exports.keys = "123456";

// add view's configurations
exports.view = {
  defaultViewEngine: 'nunjucks',
  mapping: {
    '.tpl': 'nunjucks',
  },

};

// add middleware robot
exports.middleware = [
  'robot'
];
// robot's configurations
exports.robot = {
  ua: [
    /curl/i,
    /Baiduspider/i,
  ]
};

// add news' configurations
exports.news = {
  pageSize: 5,
  //serverUrl: 'https://hacker-news.firebaseio.com/v0',
  serverUrl: 'http://192.168.1.41:9091',
};

// add sequelize' configurations
exports.sequelize = {
  dialect: 'mysql', // support: mysql, mariadb, postgres, mssql
  username:'egg',
  password:'egg',
  database: 'egg_001',
  host: '192.168.1.9',
  // username:'test',
  // password:'test',
  // database: 'egg-sequelize-example-dev',
  // host: '127.0.0.1',
  port: 3306,
};
