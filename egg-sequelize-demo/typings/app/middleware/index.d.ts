// This file is created by egg-ts-helper@1.25.2
// Do not modify this file!!!!!!!!!

import 'egg';
import ExportAuth = require('../../../app/middleware/auth');
import ExportErrorHandler = require('../../../app/middleware/error_handler');
import ExportRobot = require('../../../app/middleware/robot');
import ExportUppercase = require('../../../app/middleware/uppercase');

declare module 'egg' {
  interface IMiddleware {
    auth: typeof ExportAuth;
    errorHandler: typeof ExportErrorHandler;
    robot: typeof ExportRobot;
    uppercase: typeof ExportUppercase;
  }
}
