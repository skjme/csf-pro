package cn.chaseshu.aware.test3;

import lombok.extern.java.Log;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Log
public class ApplicationContextAwareImpl implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        log.info("setApplicationContext method called");
        this.applicationContext = applicationContext;

    }

    public void displayPersonDetails(){

        Person person = (Person)applicationContext.getBean("person");
        log.info("person.hascode() = " + person.hashCode());
        log.info("person.getName() = " + person.getName());

        log.info("applicationContext.isSingleton(\"person\") = " + applicationContext.isSingleton("person"));
    }
}
