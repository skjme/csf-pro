package cn.chaseshu.enable.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SomeBeanConfigurationDefault {

    @Bean
    public String aBean() {
        return "Default";
    }
 
}