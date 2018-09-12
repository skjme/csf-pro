package com.example.demo.dp.strategy.test;

import com.example.demo.dp.strategy.biz.SaleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringStrategyTest {

    @Autowired
    private SaleService saleService;

    @Test
    public void test(){
        saleService.sale("vip", "zhangsan");
        saleService.sale("visitor", "lisi");
    }
}
