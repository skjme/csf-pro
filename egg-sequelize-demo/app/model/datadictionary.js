'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN } = Sequelize;

  const Datadictionary = app.model.define('datadictionary', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    name: STRING(100),
    orderby: INTEGER(20),
    parent_id: INTEGER(11),
    
    // created_at: { type: DATE, defaultValue: Sequelize.NOW },
    // updated_at: DATE,
    // is_delete: { type: BOOLEAN, defaultValue: 0 },
  },
  {
    tableName: 'datadictionary',
    timestamps: false,
  }
  );

  // one to many
  Datadictionary.associate = function() {
    app.model.Datadictionary.hasMany(app.model.Datadictionary,
       { as: 'children', foreignKey: 'parent_id',
        constraints: false, 
        scope: {
          // deleted: 0,
        } 
      });

  }

  return Datadictionary;
};
