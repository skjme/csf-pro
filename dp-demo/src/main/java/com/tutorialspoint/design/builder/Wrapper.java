package com.tutorialspoint.design.builder;

/**
 * 包装纸
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
