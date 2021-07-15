package cn.chaseshu.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 基于Spring接口 注册事件
 * @see org.springframework.context.ApplicationListener
 */
public class ApplicationListenerDemo {

    public static void main(String[] args) {

        GenericApplicationContext context = new GenericApplicationContext();

        // 添加监听事件
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("监听事件:" + event);
            }
        });


        context.refresh();
        context.close();

    }
}
