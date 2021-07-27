package cn.chaseshu.thinking.in.spring.environment;

import cn.chaseshu.thinking.in.spring.environment.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 处理属性配置占位符
 * @see org.springframework.context.support.PropertySourcesPlaceholderConfigurer
 * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
 */
public class PropertySourcesPlaceholderConfigurerDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/placeholders-resovler.xml");

        User user = context.getBean("user", User.class);
        System.out.println(user);

        context.close();

    }
}
