package cn.chaseshu.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * 基于注解方式 注册事件
 * @see ApplicationListener
 */
public class AnnotationApplicationListenerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AnnotationApplicationListenerDemo.class);

        context.refresh();
        context.close();

    }

    @EventListener
    @Order(2)
    public void onApplicationEvent(ApplicationEvent event){
        System.out.println("@EventListener - 接受到 Spring 事件：" +event);
    }

    @EventListener
    @Order(1)
    public void onApplicationEvent2(ApplicationEvent event){
        System.out.println("@EventListener2 - 接受到 Spring 事件：" +event);
    }

}
