package cn.chaseshu.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class SpringBootApplicationStrap {
    
    public static void main(String[] args) {
    
       // SpringApplication.run(ApplicationConfiguration.class, args);
        
        Set<String> sources = new HashSet<>();
        
        sources.add(ApplicationConfiguration.class.getName());
    
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
    
        ConfigurableApplicationContext context = springApplication.run(args);
    
        System.out.println("bean : " + context.getBean(ApplicationConfiguration.class));
    
    
    }
    
    
    @SpringBootApplication
    static class ApplicationConfiguration{
    
    }
    
}
