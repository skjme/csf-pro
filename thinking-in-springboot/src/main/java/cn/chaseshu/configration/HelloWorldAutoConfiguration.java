package cn.chaseshu.configration;

import cn.chaseshu.annotation.EnableHelloWorld;
import cn.chaseshu.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "ask123") // 条件装配
public class HelloWorldAutoConfiguration {

}
