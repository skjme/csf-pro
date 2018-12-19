// Enable plugin sequelize
exports.sequelize = {
  enable: true,
  package: 'egg-sequelize',
};

// Enable plugin cors 
// 开启 cros 跨域访问
exports.cors = {
  enable: true,
  package: 'egg-cors',
};

// Enable plugin nunjucks
exports.nunjucks = {
  enable: true,
  package: 'egg-view-nunjucks'
};
