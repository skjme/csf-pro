package com.example.demo.dp.observer.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 创建订单
     * @param name
     */
    public void saveOrder(String name){

        // 1 创建订单
        System.out.println("恭喜【"+name+"】创建了。。。。订单");

        // 通过Spring 发布一个订单创建事件，监听者收到之后执行相应逻辑
        // 1 事件OrderEvent
        // 2 发布渠道
        applicationContext.publishEvent(new OrderEvent(name));

        // 3 监听者

    }
}
