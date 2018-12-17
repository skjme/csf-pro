exports.keys = "123456";

exports.security = {
    csrf: {
        enable: false,
        ignoreJSON: true,
    }
}

exports.cors = {
    origin: '*',
    allowMethods: 'GET,HEAD,PUT,POST,DELETE,PATCH'
};