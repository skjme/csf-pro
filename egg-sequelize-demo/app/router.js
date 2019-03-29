module.exports = app => {
    const { router, controller, middlewares } = app;

    router.get('index', '/home/index', controller.home.index);
    router.redirect('/', '/home/index', 302);

    // RESTful 风格的 URL 定义
    router.resources('post', '/api/post', controller.post);
    router.resources('users', '/api/v1/users',  controller.v1.users);
    router.resources('users', '/users',  controller.users);

    router.resources('mgr_channel', '/mgr/api/channel', controller.mgr.api.channel);
    router.resources('mgr_trainee', '/mgr/api/trainee', controller.mgr.api.trainee);
    router.resources('mgr_member', '/mgr/api/member', controller.mgr.api.member);
    
    router.get('/mgr/api/activityphase/getPhase', controller.mgr.api.activityphase.getPhase);
    router.get('/mgr/api/activityphase/getNum', controller.mgr.api.activityphase.getNum);
    router.get('/mgr/api/activityphase/getIndustry', controller.mgr.api.activityphase.getIndustry);
    router.get('/mgr/api/activityphase/getProvince', controller.mgr.api.activityphase.getProvince);

    //  登录
    router.post('/api/login/account', controller.mgr.api.admin.login);
    router.get('/api/currentUser/:id', controller.mgr.api.admin.currentUser);

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
