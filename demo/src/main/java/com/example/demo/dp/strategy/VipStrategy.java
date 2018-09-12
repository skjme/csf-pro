package com.example.demo.dp.strategy;

import org.springframework.stereotype.Component;

@Component
public class VipStrategy implements DabaojianSale {
    @Override
    public String type() {
        return "vip";
    }

    @Override
    public void sale(String name) {
        System.out.println("vip 收费 58");
    }
}
