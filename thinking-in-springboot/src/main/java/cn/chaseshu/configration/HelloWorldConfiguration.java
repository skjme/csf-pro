package cn.chaseshu.configration;

import org.springframework.context.annotation.Bean;

public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){
        return "Hello, World 2021!";
    }
}
