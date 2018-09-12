package com.example.demo.dp.observer.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 订单事件监听者 -- 发短信
 */
@Component
public class SmsListener implements SmartApplicationListener {

    /**
     *  收到事件之后， 执行的业务逻辑
     * @param event
     * @return
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("执行了，发送短信逻辑。。。。。");
    }

    /**
     *  执行顺序
     * @return
     */
    @Override
    public int getOrder() {
        // 多个监听， 可以定义顺序 asc
        return 50;
    }

    /**
     *  专注某一个事件
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == OrderEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }




}
