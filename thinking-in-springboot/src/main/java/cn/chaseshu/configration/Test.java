package cn.chaseshu.configration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
//@ComponentScan(excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
//                MyConfig.class
//        })
//})
public class Test {
    
    public static void main(String[] args) {
        new SpringApplication(Test.class).run(args);
    }
    
}
