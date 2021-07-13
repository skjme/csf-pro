package com.tutorialspoint.design.builder;

/**
 * 百事可乐
 */
public class Pepsi extends ColdDrink{

    @Override
    public String name() {
        return "百事可乐";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
