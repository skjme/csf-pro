package cn.chaseshu.enable.test3;

import lombok.extern.java.Log;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * @Enable*注解的工作原理
 * https://www.jianshu.com/p/3da069bd865c
 *
 */
@Log
@ComponentScan("cn.chaseshu.enable.test3")
@EnableEcho(packages = {"cn.chaseshu.enable.test3.vo", "cn.chaseshu.enable.test3.dto"})
public class TestApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestApp.class);
        context.refresh();

        int count = context.getBeanDefinitionCount();
        log.info(" beanDefinitionCount = " + count);
        val beanDefinitionNames = context.getBeanDefinitionNames();
        log.info("beanDefinitionNames ===== " );
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);


    }
}
