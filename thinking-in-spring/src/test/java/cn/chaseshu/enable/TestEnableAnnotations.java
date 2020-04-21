package cn.chaseshu.enable;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestEnableAnnotations {

    @Autowired
    private String aBean1;

    @Autowired
    private String aBean2;

    @Test
    public void testEnableShouldLoadFamilyOfBeans() {
        Assert.assertEquals(aBean1, "aBean1");
        Assert.assertEquals(aBean2, "aBean2");
    }

    @Configuration
    @EnableSomeBeans
    public static class SpringConfig {}
}