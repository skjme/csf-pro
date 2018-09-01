package com.chaseshu.service;

public class OrderService{


    public void createOrder(Integer userId, String content){

        //1 数据库操作，（ create order、创建本地消息），独立事务

        //2 引入消息队列MQ，发送一条消息，通知下游系统， 做接下来的业务处理
    }
}