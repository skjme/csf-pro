// This file is created by egg-ts-helper@1.25.2
// Do not modify this file!!!!!!!!!

import 'egg';
import ExportActivityphase = require('../../../app/service/activityphase');
import ExportAdmin = require('../../../app/service/admin');
import ExportChannel = require('../../../app/service/channel');
import ExportMd5 = require('../../../app/service/md5');
import ExportMember = require('../../../app/service/member');
import ExportNews = require('../../../app/service/news');
import ExportPost = require('../../../app/service/post');
import ExportSome = require('../../../app/service/some');
import ExportToken = require('../../../app/service/token');
import ExportTrainee = require('../../../app/service/trainee');
import ExportUser = require('../../../app/service/user');

declare module 'egg' {
  interface IService {
    activityphase: ExportActivityphase;
    admin: ExportAdmin;
    channel: ExportChannel;
    md5: ExportMd5;
    member: ExportMember;
    news: ExportNews;
    post: ExportPost;
    some: ExportSome;
    token: ExportToken;
    trainee: ExportTrainee;
    user: ExportUser;
  }
}
