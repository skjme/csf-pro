// This file is created by egg-ts-helper@1.25.2
// Do not modify this file!!!!!!!!!

import 'egg';
import ExportForm = require('../../../app/controller/form');
import ExportHome = require('../../../app/controller/home');
import ExportNews = require('../../../app/controller/news');
import ExportPost = require('../../../app/controller/post');
import ExportSearch = require('../../../app/controller/search');
import ExportToken = require('../../../app/controller/token');
import ExportUsers = require('../../../app/controller/users');
import ExportV1Users = require('../../../app/controller/v1/users');
import ExportMgrApiActivityphase = require('../../../app/controller/mgr/api/activityphase');
import ExportMgrApiAdmin = require('../../../app/controller/mgr/api/admin');
import ExportMgrApiChannel = require('../../../app/controller/mgr/api/channel');
import ExportMgrApiMember = require('../../../app/controller/mgr/api/member');
import ExportMgrApiPost = require('../../../app/controller/mgr/api/post');
import ExportMgrApiTrainee = require('../../../app/controller/mgr/api/trainee');

declare module 'egg' {
  interface IController {
    form: ExportForm;
    home: ExportHome;
    news: ExportNews;
    post: ExportPost;
    search: ExportSearch;
    token: ExportToken;
    users: ExportUsers;
    v1: {
      users: ExportV1Users;
    }
    mgr: {
      api: {
        activityphase: ExportMgrApiActivityphase;
        admin: ExportMgrApiAdmin;
        channel: ExportMgrApiChannel;
        member: ExportMgrApiMember;
        post: ExportMgrApiPost;
        trainee: ExportMgrApiTrainee;
      }
    }
  }
}
