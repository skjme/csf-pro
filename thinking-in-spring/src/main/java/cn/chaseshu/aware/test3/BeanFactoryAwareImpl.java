package cn.chaseshu.aware.test3;

import lombok.extern.java.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

@Log
public class BeanFactoryAwareImpl implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        log.info("setBeanFactory method called");
        this.beanFactory = beanFactory;

    }

    public void displayPersonDetails(){

        Person person = (Person)beanFactory.getBean("person");
        log.info("person.hascode() = " + person.hashCode());
        log.info("person.getName() = " + person.getName());

        log.info("beanFactory.isSingleton(\"person\") = " + beanFactory.isSingleton("person"));
    }
}
