package cn.chaseshu.enable.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableHelloWorldBootstrap.class);
        context.refresh();

        String helloworld = context.getBean("helloWorld", String.class);
        System.out.println(helloworld);

    }
}
