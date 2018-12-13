module.exports = app => {
    const { router, controller, middlewares } = app;

    router.get('/', controller.home.index);
    router.get('/user', controller.user.index);
    
    // RESTful 风格的 URL 定义
    router.resources('posts', '/api/posts', controller.posts);
    // router.resources('users', '/api/v1/users',  controller.v1.users);
    router.resources('users', '/users',  controller.users);

    // router.get('/users', isLoginUser, hasAdminPermission, controller.user.index);
    
    router.get('/news', controller.news.list);
    router.get('/news/:id', controller.news.detail);

    router.post('/form', controller.form.post);

    router.get('s', '/search', middlewares.uppercase(), controller.search.index);

    router.get('getToken', '/token', controller.token.index);
    router.get('verifyToken', '/token/decode', controller.token.decode);

  };