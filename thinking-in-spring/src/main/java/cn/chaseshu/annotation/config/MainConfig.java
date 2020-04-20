package cn.chaseshu.annotation.config;

import cn.chaseshu.bean.MyTestBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class MainConfig {

    @Bean("myTestBean2")
    public MyTestBean myTestBean(){
        return new MyTestBean();
    }
}
