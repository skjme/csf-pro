'use strict';

const Service = require('egg').Service;
const jwt = require('jsonwebtoken');

const SECRET_KEY = '3d990d2276917dfac04467df11fff26d';

class TokenService extends Service {

  async signJwt_(_id) {
    return jwt.sign({
      data: {
        _id,
      },
      exp: Math.floor(Date.now() / 1000) + (60 * 60 * 24 * 7),
    }, SECRET_KEY);
  }

  async signJwt(_id) {
    return jwt.sign({
      appid: _id.appid,
      uid: _id.uid,
      scid: _id.scid,
      iat: Math.floor(Date.now()),
      ext: Math.floor(Date.now()) + (1000 * 60 * 60 * 24 * 7),
    }, SECRET_KEY);
  }

  async decodeJwt(token) {
    try {
      const ctx = this.ctx;
      const res = jwt.verify(token, SECRET_KEY);
      res.iat_ = ctx.helper.formatTime(res.iat);
      res.ext_ = ctx.helper.formatTime(res.ext);
      res.isExpire = ctx.helper.isExpire(res.ext);
      res.ok = res.isExpire;
      if (!res.isExpire) {
        res.message = 'Expire token';
      }
      return res;
    } catch (err) {
      err.ok = false;
      err.message = err.message;
      return err;
    }
  }
  async getScid() {
    try {
      const ctx = this.ctx;
      const token = ctx.header.authorization || ctx.query.token;
      const res = await this.decodeJwt(token);
      console.log('====================');
      console.log('=======getScid:\n', res);
      console.log('===================');
      return res.scid || 0;
    } catch (err) {
      return -1;
    }
  }
}

module.exports = TokenService;
