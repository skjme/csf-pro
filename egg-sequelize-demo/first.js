// create floder && cd floder
// npm init 
// npm install --save sequelize
// npm install --save mysql2
const Sequelize = require('sequelize');

// const sequelize = new Sequelize("mysql://username:password@211.**.119.**:3306/dbname?useUnicode=true&characterEncoding=UTF-8");

//ALTER USER 'test'@'localhost' IDENTIFIED WITH mysql_native_password BY 'test'
//https://blog.csdn.net/weixin_36094484/article/details/83479992 mysql 8.0.4
const sequelize = new Sequelize('test_001', 'test', 'test', {
    host: 'localhost',
    dialect: 'mysql',
    operatorsAliases: false,

    pool: {
        max: 5,
        min: 0,
        acquire: 30000,
        idle: 10000
    },

    define: {
        timestamps: false // true by default
    }
});


// Test the connection
// sequelize.authenticate()
// .then(() => {
//     console.log('Connnection has been establisheed successfully');
// })
// .catch( err => {
//     console.error("Unable to connect to the database:\n", err);
// });


// define model
const User = sequelize.define('user', {
    firstName:{
        type: Sequelize.STRING
    },
    lastName:{
        type: Sequelize.STRING
    },
});

const Post = sequelize.define('post', {
        title:{
            type: Sequelize.STRING
        },
        content:{
            type: Sequelize.STRING
        },
    },{
        timestamps: true
    });

// insert record
// *** force: true will drop the table if it already exists
// User.sync({ force: false}).then( () => {

//     return User.create({
//         firstName:'chase2',
//         lastName: 'shu2'
//     });
// });

// Post.sync({ force: false}).then( () => {

//     return Post.create({
//         title:'this is a title',
//         content: '11111'
//     });
// });

//query
// User.findAll().then( users => {
//     console.log(users);
// });
User.findOne().then( user =>{

    console.log("firstName=" , user.get("firstName"));
    
});

// user = await User.findOne();
// console.log(user.get('firstName'));