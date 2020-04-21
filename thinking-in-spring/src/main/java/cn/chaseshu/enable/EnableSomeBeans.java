package cn.chaseshu.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// 如果希望引入一组新的bean, 只需要简单的使用@Import注解
@Import(SomeBeanConfiguration.class)
@interface EnableSomeBeans {
}
