package cn.chaseshu.bootstrap;

import cn.chaseshu.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "cn.chaseshu.service")
public class CalculateServiceBoostrap {
    
    public static void main(String[] args) {
    
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBoostrap.class).web(
                WebApplicationType.NONE)
//                .profiles("Java7")
//                .profiles("Java8")
                .run(args);
    
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    
        System.out.println("=======");
        CalculateService bean = context.getBean(CalculateService.class);
        System.out.println(bean.sum(1,2,3,4,5,6,7,8,9,10));
        
        context.close();
        
    }
    
}
