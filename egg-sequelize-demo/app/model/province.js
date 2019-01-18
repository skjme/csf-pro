'use strict';

module.exports = app => {
  const { Sequelize } = app;
  const { STRING, INTEGER, DATE, BOOLEAN } = Sequelize;

  const Province = app.model.define('province', {
    id: { type: INTEGER, primaryKey: true, autoIncrement: true },
    title: STRING(100),
    parent_id: INTEGER(11),
    
    // created_at: { type: DATE, defaultValue: Sequelize.NOW },
    // updated_at: DATE,
    // is_delete: { type: BOOLEAN, defaultValue: 0 },
  },
  {
    tableName: 'province',
    timestamps: false,
  }
  );

  // one to many
  Province.associate = function() {
    app.model.Province.hasMany(app.model.Province,
       { as: 'children', foreignKey: 'parent_id',
        constraints: false, 
        scope: {
          // deleted: 0,
        } 
      });

  }

  return Province;
};
