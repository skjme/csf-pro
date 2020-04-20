package cn.chaseshu.aware.applicationcontextawware;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beanFactoryTest.xml");

        int hashCode = context.getBean("myContext").hashCode();
        System.out.println(hashCode);
    }
}
