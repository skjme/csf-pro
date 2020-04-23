package cn.chaseshu.enable.test2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//如果criteria是detault, SomeBeanConfigurationDefault被加入，
// 反之，加入SomeBeanConfigurationType1。
//@EnableSomeBeansSelector(criteria = "default")
@EnableSomeBeansSelector(criteria = "type1")
public class TestEnableSomeBeanSelector {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestEnableSomeBeanSelector.class);
        context.refresh();

        String aBean = context.getBean("aBean", String.class);
        System.out.println(aBean);
    }
}
