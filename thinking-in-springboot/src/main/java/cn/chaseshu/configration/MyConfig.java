package cn.chaseshu.configration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@IgnoreScan
public class MyConfig {
    
    @Bean
    public BeanPostProcessor beanPostProcessor(){
        System.out.println("初始化了 bean BeanPostProcessor");
        
        return new BeanPostProcessor(){
            
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
            }
    
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("加载了bean " + beanName);
                return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
            }
        };
        
    }
    
}
