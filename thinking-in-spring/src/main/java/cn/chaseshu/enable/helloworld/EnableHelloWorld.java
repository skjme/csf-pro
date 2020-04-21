package cn.chaseshu.enable.helloworld;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
// @Import注解用于导入一个和多个ConfigurationClass,将其注册为SpringBean。
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}