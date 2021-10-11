package cn.chaseshu.thinking.in.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AsyncEventHandlerDemo {
    
    public static void main(String[] args) {
        
        GenericApplicationContext context = new GenericApplicationContext();
    
        // 1 添加自定义Spring事件监听器
        context.addApplicationListener(new MySpringEventListener());
        
        // 2 启动 Spring 上下文
        context.refresh();
    
        
        ApplicationEventMulticaster applicationEventMulticaster = context.getBean(
                AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);
        
        if(applicationEventMulticaster instanceof SimpleApplicationEventMulticaster){
            SimpleApplicationEventMulticaster simpleApplicationEventMulticaster =
                    (SimpleApplicationEventMulticaster)applicationEventMulticaster;
            
            simpleApplicationEventMulticaster.setTaskExecutor(Executors.newSingleThreadExecutor(
                    new CustomizableThreadFactory("my-spring-event")));
        }
        
    
        // 3 发布自定义事件
        context.publishEvent(new MySpringEvent("Hello, World"));
        
        // 4 关闭 Spring 上下文
        context.close();
    }
    
    @Async // 同步 -> 异步
    @EventListener
    public void onEvent(MySpringEvent event){
        System.out.printf("[线程 ： %s] onEvent方法监听到事件：%s\n", Thread.currentThread().getName(), event);
    }
    
    @Bean
    public Executor taskExecutor(){
        ExecutorService taskExecutor = Executors.newSingleThreadExecutor(
                new CustomizableThreadFactory("my-spring-event-thread-pool-a"));
        return taskExecutor;
        
    }
    
}
