package cn.chaseshu.aware.applicationcontextaware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyApplicationContext implements ApplicationContextAware, BeanNameAware {

    private String beanName;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        //通过重写的接口方法，获取spring容器实例context，进而获取容器中相关bean资源
        System.out.println(context.getBean(this.beanName).hashCode());
    }

    //注入的beanName即为MyApplicationContext在BeanFactory配置中的名字（根据情况是id或者name）
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("MyApplicationContext beanName:"+beanName);

    }
}
