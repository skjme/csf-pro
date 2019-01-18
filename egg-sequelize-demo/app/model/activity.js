'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN } = Sequelize;

  const Activity = app.model.define('activity', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    title: STRING(100),
    phase: INTEGER(11),
    num: INTEGER(11),
    // orderby:INTEGER(20),
    
    // created_at: { type: DATE, defaultValue: Sequelize.NOW },
    // updated_at: DATE,
    // is_delete: { type: BOOLEAN, defaultValue: 0 },
  },
  {
    tableName: 'activity',
    timestamps: false,
  }
  );

  // one to many
  Activity.associate = function() {

      app.model.Activity.belongsTo(app.model.Province,
        { as: 'cityObj', foreignKey: 'city',
         constraints: false, 
         scope:{
        //    is_delete: 0,
         } 
       });
  }

  return Activity;
};
