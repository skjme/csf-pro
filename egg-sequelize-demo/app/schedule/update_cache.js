const Subscription = require('egg').Subscription;

class UpdateCache extends Subscription {

    // using `schedule` property to set the scheduled task execution interval and other configurations
    static get schedule() {
        return {
            // interval: '1m', // 1 minute interval
            interval: '10s', // 10 second interval
            type: 'all', // specify all `workers` need to execute
        };
    }

    // `subscribe` is the function to be executed when the scheduled task is triggered
    async subscribe() {
        const res = await this.ctx.curl('http://www.mima96.com/wap/ifu.json', {
            dataType: 'json',
        });
      //  console.log('res', res);
        this.ctx.app.cache = res.data;
    }

}

module.exports = UpdateCache;