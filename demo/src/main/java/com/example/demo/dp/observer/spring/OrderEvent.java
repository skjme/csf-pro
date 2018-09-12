package com.example.demo.dp.observer.spring;

import org.springframework.context.ApplicationEvent;

/**
 * 定义一个订单事件
 */
public class OrderEvent extends ApplicationEvent {


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OrderEvent(Object source) {
        super(source);
    }
}
