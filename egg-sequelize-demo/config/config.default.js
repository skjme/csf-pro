exports.keys = "123456";

// add middleware auth, robot
exports.middleware = [ 
  // 'errorHandler',
  //'auth',
  //'robot'
];

// api-auth's configurations
exports.auth = {
  uri: [
    /api/i,
    /users/i,
  ]
};

// robot's configurations
exports.robot = {
  ua: [
    /curl/i,
    /Baiduspider/i,
  ]
};

// cors
exports.cors = {
  origin: '*',
  allowMethods: 'GET,HEAD,PUT,POST,DELETE,PATCH'
};

// csrf
exports.security = {
  csrf: {
    enable: false,
    // queryName: '_csrf', // 通过 query 传递 CSRF token 的默认字段为 _csrf
    // bodyName: '_csrf', // 通过 body 传递 CSRF token 的默认字段为 _csrf
    // headerName: 'x-csrf-token', // 通过 header 传递 CSRF token 的默认字段为 x-csrf-token
  },
};




// add sequelize' configurations
exports.sequelize = {
  dialect: 'mysql', // support: mysql, mariadb, postgres, mssql
  // username:'egg',
  // password:'egg',
  // database: 'egg_001',
  // host: '192.168.1.9',
  username: 'test',
  password: 'test',
  // host: 'localhost',
  database: 'egg-sequelize-doc-unittest',
  // database: 'egg-sequelize-doc-default',
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

// add news' configurations
// exports.news = {
//   pageSize: 5,