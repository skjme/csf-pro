package cn.chaseshu.enable.helloworld;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableHelloWorldBootstrap.class);
        context.refresh();

        String helloworld = context.getBean("helloWorld", String.class);
        log.info(helloworld);

    }
}
