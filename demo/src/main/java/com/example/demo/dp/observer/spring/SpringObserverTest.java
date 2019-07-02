package com.example.demo.dp.observer.spring;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SpringObserverTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test(){
        orderService.saveOrder("chaseshu");
    }
}
