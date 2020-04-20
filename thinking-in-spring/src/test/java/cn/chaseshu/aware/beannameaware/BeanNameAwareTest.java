package cn.chaseshu.aware.beannameaware;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanNameAwareTest {

    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beanFactoryTest.xml");

        User u = context.getBean(User.class);
        System.out.println(u);

        User2 user2 = context.getBean(User2.class);
        System.out.println(user2);
    }
}
