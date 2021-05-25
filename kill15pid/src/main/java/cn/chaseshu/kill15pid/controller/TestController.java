package cn.chaseshu.kill15pid.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @GetMapping(value = "/test")
    public String test(){
        log.info("test --- start");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test --- end");
        return "test";
    }


    /**
     * 停机
     */
    @PostMapping("shutdown")
    public void shutdown(){
        ConfigurableApplicationContext cac = (ConfigurableApplicationContext) context;
        cac.close();
    }

}
