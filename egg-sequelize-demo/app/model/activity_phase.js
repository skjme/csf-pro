'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN } = Sequelize;

  const ActivityPhase = app.model.define('activity_phase', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    name: STRING(100),
    ext1: INTEGER(11),
    ext3:STRING(100),
    ext4: INTEGER(11),
    orderby:INTEGER(20),
    
    // created_at: { type: DATE, defaultValue: Sequelize.NOW },
    // updated_at: DATE,
    // is_delete: { type: BOOLEAN, defaultValue: 0 },
  },
  {
    tableName: 'activity_phase',
    timestamps: false,
  }
  );
// one to many
ActivityPhase.associate = function() {
  app.model.ActivityPhase.hasMany(app.model.Activity,
     { as: 'actNum', foreignKey: 'phase',
      constraints: false, 
      scope: {
        is_delete: 0,
      } 
    });

}

  return ActivityPhase;
};