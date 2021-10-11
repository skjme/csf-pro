package cn.chaseshu.thinking.in.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@EnableAsync // 激活Spring 异步
public class AnnotatedAsyncEventHandlerDemo {
    
    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    
        // 1 注册当前类为 Configuration Class
        context.register(AnnotatedAsyncEventHandlerDemo.class);
        
        // 2 启动 Spring 上下文
        context.refresh();
    
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
