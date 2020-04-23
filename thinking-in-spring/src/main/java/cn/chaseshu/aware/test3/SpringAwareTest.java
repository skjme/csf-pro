package cn.chaseshu.aware.test3;

import lombok.extern.java.Log;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log
public class SpringAwareTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("META-INF/beans.xml");

        ApplicationContextAwareImpl applicationContextAware = (ApplicationContextAwareImpl) applicationContext.getBean("applicationContextAware");

        log.info("Application context aware output");
        applicationContextAware.displayPersonDetails();

        BeanFactoryAwareImpl beanFactoryAware = (BeanFactoryAwareImpl) applicationContext.getBean("beanFactoryAware");

        log.info("Bean Factory  aware output");
        beanFactoryAware.displayPersonDetails();


    }
}
