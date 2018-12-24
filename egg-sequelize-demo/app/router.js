module.exports = app => {
    const { router, controller, middlewares } = app;

    router.get('index', '/home/index', controller.home.index);
    router.redirect('/', '/home/index', 302);

    // RESTful 风格的 URL 定义
    router.resources('posts', '/api/posts', controller.posts);
    router.resources('users', '/api/v1/users',  controller.v1.users);
    router.resources('users', '/users',  controller.users);

    router.get('post-index ', '/post/index',  controller.post.index);
    router.get('post-show ', '/post/:id', controller.post.show);
    router.post('/post', controller.post.create);
    router.put('/post/:id', controller.post.update);

    // router.get('/users', isLoginUser, hasAdminPermission, controller.user.index);

    router.post('/form', controller.form.post);


    router.get('s', '/search', middlewares.uppercase(), controller.search.index);

    router.get('encodeToken', '/token/encode', controller.token.index);
    router.get('verifyToken', '/token/decode', controller.token.decode);
    router.redirect('/token/get', '/token/encode', 302);

  };