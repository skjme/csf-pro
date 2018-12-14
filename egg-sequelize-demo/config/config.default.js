exports.keys = "123456";



// add middleware robot, auth
exports.middleware = [
  'robot', 'auth'
];

// robot's configurations
exports.robot = {
  ua: [
    /curl/i,
    /Baiduspider/i,
  ]
};

// api-auth's configurations
exports.auth = {
  uri: [
    /api/i,
    /users/i,
  ]
};

// add news' configurations
// exports.news = {
//   pageSize: 5,
//   //serverUrl: 'https://hacker-news.firebaseio.com/v0',
//   serverUrl: 'http://192.168.1.41:9091',
// };

// add sequelize' configurations
exports.sequelize = {
  dialect: 'mysql', // support: mysql, mariadb, postgres, mssql
  // username:'egg',
  // password:'egg',
  // database: 'egg_001',
  // host: '192.168.1.9',
  username: 'test',
  password: 'test',
  database: 'egg-sequelize-doc-unittest',
  host: '192.168.1.9',
  port: 3306,
};

// add view's configurations
exports.view = {
  defaultViewEngine: 'nunjucks',
  mapping: {
    '.tpl': 'nunjucks',
  },

};