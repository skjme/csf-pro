package cn.chaseshu.thinking.in.spring.ioc.overview.dependence.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖查找
 */
public class DependenceLookupDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("");
    }
}
