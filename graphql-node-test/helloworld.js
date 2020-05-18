const express = require('express');
const { buildSchema } = require("graphql");
const graphqlHTTP = require('express-graphql');

// 定义schema、查询与类型
const schema = buildSchema(`
    type Account {
        name: String
        age: Int 
        sex: String 
        department: String 
    }
    type Query{
        hello: String,
        accountName: String
        age: Int 
        account: Account
    }
`)

// 定义查询对应的处理器
const root = {
    hello: () => {
        return 'hello world';
    },
    accountName: () => {
        return '张三';
    },
    age: () => {
        return 18;
    },
    account: () => {
        return {
            name: '李四光',
            age: 18,
            sex: '男',
            department: '科学院'
        };
    }
}

const app = express();

app.use('/graphql', graphqlHTTP({
    schema: schema,
    rootValue: root,
    graphiql: true // 是否开启调试
}
));

app.listen(3000);

