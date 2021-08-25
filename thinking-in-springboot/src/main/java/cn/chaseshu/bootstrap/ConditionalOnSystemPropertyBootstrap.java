package cn.chaseshu.bootstrap;

import cn.chaseshu.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

public class ConditionalOnSystemPropertyBootstrap {
    
    @Bean
//    @ConditionalOnSystemProperty(name = "user.name", value = "chaseshu")
    @ConditionalOnSystemProperty(name = "user.name", value = "ask123")
    public String helloWorld(){
        return "Hello, World! chaseshu";
    }
    
    public static void main(String[] args) {
    
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        final String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("hellowrold Bean : " + helloWorld);
        
        context.close();
    }
    
}
