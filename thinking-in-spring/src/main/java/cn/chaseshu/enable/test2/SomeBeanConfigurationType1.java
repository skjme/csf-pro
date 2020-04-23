package cn.chaseshu.enable.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SomeBeanConfigurationType1 {

    @Bean
    public String aBean() {
        return "Type1";
    }
 
}