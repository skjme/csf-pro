const moment = require('moment');
exports.relativeTime = time => moment(new Date(time * 1000)).fromNow();

// 格式化时间
exports.formatTime = time => moment(time).format('YYYY-MM-DD HH:mm:ss')

// 处理成功响应
exports.success = ({ ctx, res = null, message = '请求成功' })=> {
    ctx.body = {
      code: 0,
      data: res,
      message,
      success: true
    }
    ctx.status = 200
  }
  