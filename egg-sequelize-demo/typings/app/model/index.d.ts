// This file is created by egg-ts-helper@1.25.2
// Do not modify this file!!!!!!!!!

import 'egg';
import ExportActivity = require('../../../app/model/activity');
import ExportActivityPhase = require('../../../app/model/activity_phase');
import ExportActivitySeries = require('../../../app/model/activity_series');
import ExportAdmin = require('../../../app/model/admin');
import ExportChannel = require('../../../app/model/channel');
import ExportDatadictionary = require('../../../app/model/datadictionary');
import ExportMember = require('../../../app/model/member');
import ExportPost = require('../../../app/model/post');
import ExportProvince = require('../../../app/model/province');
import ExportTrainee = require('../../../app/model/trainee');
import ExportTraineeGraduationNumber = require('../../../app/model/trainee_graduation_number');
import ExportUser = require('../../../app/model/user');

declare module 'sequelize' {
  interface Sequelize {
    Activity: ReturnType<typeof ExportActivity>;
    ActivityPhase: ReturnType<typeof ExportActivityPhase>;
    ActivitySeries: ReturnType<typeof ExportActivitySeries>;
    Admin: ReturnType<typeof ExportAdmin>;
    Channel: ReturnType<typeof ExportChannel>;
    Datadictionary: ReturnType<typeof ExportDatadictionary>;
    Member: ReturnType<typeof ExportMember>;
    Post: ReturnType<typeof ExportPost>;
    Province: ReturnType<typeof ExportProvince>;
    Trainee: ReturnType<typeof ExportTrainee>;
    TraineeGraduationNumber: ReturnType<typeof ExportTraineeGraduationNumber>;
    User: ReturnType<typeof ExportUser>;
  }
}
