'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN } = Sequelize;

  const ActivitySeries = app.model.define('activity_series', {
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
    tableName: 'activity_series',
    timestamps: false,
  }
  );


  // one to many
  ActivitySeries.associate = function() {
    app.model.ActivitySeries.hasMany(app.model.ActivityPhase,
       { as: 'children', foreignKey: 'ext4',
        constraints: false, 
        scope: {
        deleted: 0,
        } 
      });

  }
  return ActivitySeries;
};
