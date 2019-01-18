'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN, DOUBLE } = Sequelize;

  const Trainee = app.model.define('trainee', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    name: STRING(120),
    gender: STRING(3),
    photo_m: STRING(100),
    id_card: STRING(100),
    birthday: STRING(60),
    mobile: STRING(60),
    company: STRING(200),
    position: STRING(300),
    channel_id: INTEGER,
    recommend_id: INTEGER,
    industry:DOUBLE,
    industry_ext:DOUBLE,
    province:DOUBLE,
    city:DOUBLE,
    county:DOUBLE,
    address:STRING(400),
    created_name:STRING(45),
    created_at: { type: DATE, defaultValue: Sequelize.NOW },
    updated_at: DATE,
    is_delete: { type: BOOLEAN, defaultValue: 0 },
  },
  {
    tableName: 'trainee',
  }
  );


  // one to many
  Trainee.associate = function() {
    app.model.Trainee.hasMany(app.model.TraineeGraduationNumber,
       { as: 'tgns', foreignKey: 'trainee_id',
        constraints: false, 
        scope: {
          is_delete: 0,
        } 
      });

      app.model.Trainee.belongsTo(app.model.Channel,
        { as: 'channel', foreignKey: 'channel_id',
         constraints: false, 
         scope:{
           is_delete: 0,
         } 
       });

  }

  return Trainee;
};