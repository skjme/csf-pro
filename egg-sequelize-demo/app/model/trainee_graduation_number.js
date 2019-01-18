'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN } = Sequelize;

  const TraineeGraduationNumber = app.model.define('trainee_graduation_number', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    num: INTEGER(11),//账号
    phase: INTEGER(11),
    type:STRING(32),
    trainee_id:INTEGER(11),
    
    // created_at: { type: DATE, defaultValue: Sequelize.NOW },
    // updated_at: DATE,
    // is_delete: { type: BOOLEAN, defaultValue: 0 },
  },
  {
    tableName: 'trainee_graduation_number',
    timestamps: false,
  }
  );

//   Post.associate = function() {
//     app.model.Post.belongsTo(app.model.User, { as: 'user' });
//   };

// one to many
TraineeGraduationNumber.associate = function() {

     app.model.TraineeGraduationNumber.belongsTo(app.model.ActivityPhase,
      { as: 'phaseObj', foreignKey: 'phase', targetKey: 'ext1',
       constraints: false, 
       scope:{
          deleted: 0,
       } 
     });

}

  return TraineeGraduationNumber;
};
