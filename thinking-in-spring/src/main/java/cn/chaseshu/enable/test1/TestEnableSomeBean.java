package cn.chaseshu.enable.test1;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log
@EnableSomeBeans
public class TestEnableSomeBean {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestEnableSomeBean.class);
        context.refresh();

        String aBean1 = context.getBean("aBean1", String.class);
        log.info("aBean1=" + aBean1);

        String aBean2 = context.getBean("aBean2", String.class);
        log.info("aBean2=" + aBean2);
    }
}
