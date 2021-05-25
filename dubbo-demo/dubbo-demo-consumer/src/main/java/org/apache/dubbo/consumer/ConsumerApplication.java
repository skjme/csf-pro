package org.apache.dubbo.consumer;

import org.apache.dubbo.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerApplication {

    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/consumer.xml"});
        context.start();

        // 获取远程服务代理
        // Obtaining a remote service proxy
        DemoService demoService = (DemoService)context.getBean("demoService");

        // 执行远程方法
        // Executing remote methods
        String hello = demoService.sayHello("world");

        // 显示调用结果
        // Display the call result
        System.out.println(hello);

    }
}
