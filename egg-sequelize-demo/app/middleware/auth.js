// options === app.config.auth
module.exports = (options, app) => {
    return async function auth(ctx, next) {

        const requrl = ctx.request.url || '';
        console.log('requrl', requrl);
        
        const match = options.uri.some(uri => uri.test(requrl));
        console.log('match', match);
        
        if (match) {
            // check token
            const token = ctx.query.token;
            console.log('token', token);
            
            if(!token){
                ctx.status = 401; // 401 Unauthorized 403 Forbidden
                ctx.message = 'no auth.';
                return;
            }

            const decodeResult = await ctx.service.token.decodeJwt(token);
            console.log('decodeResult', decodeResult);
            console.log('decodeResult.data', decodeResult.data);
            if(!decodeResult.data){
                ctx.status = 401; // 401 Unauthorized 403 Forbidden
                ctx.message = 'Invalid token.';
                return;
                return;
            }
       
            
            await next();
            
        } else {
            await next();
        }
    }
}