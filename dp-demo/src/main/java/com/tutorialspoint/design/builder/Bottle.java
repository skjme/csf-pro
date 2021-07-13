package com.tutorialspoint.design.builder;

/**
 * 瓶子包装
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
