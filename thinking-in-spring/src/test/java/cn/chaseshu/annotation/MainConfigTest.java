package cn.chaseshu.annotation;

import cn.chaseshu.annotation.config.MainConfig;
import cn.chaseshu.bean.MyTestBean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfigTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        MyTestBean myTestBean = (MyTestBean)applicationContext.getBean("myTestBean2");
        MyTestBean myTestBean2 = (MyTestBean)applicationContext.getBean("myTestBean2");
        Assert.assertEquals(myTestBean.getTestStr(), "testStr");
        Assert.assertEquals(myTestBean, myTestBean2);
    }
}
