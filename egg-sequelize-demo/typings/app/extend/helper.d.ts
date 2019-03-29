// This file is created by egg-ts-helper@1.25.2
// Do not modify this file!!!!!!!!!

import 'egg';
import ExtendIHelper = require('../../../app/extend/helper');
declare module 'egg' {
  type ExtendIHelperType = typeof ExtendIHelper;
  interface IHelper extends ExtendIHelperType { }
}