package com.example.demo.dp.strategy;


import org.springframework.stereotype.Component;

@Component
public class VisitorStrategy implements DabaojianSale {
    @Override
    public String type() {
        return "visitor";
    }

    @Override
    public void sale(String name) {
        System.out.println("普通客户 收费 88");
    }
}
