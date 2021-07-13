package com.tutorialspoint.design.builder;

/**
 * 蔬菜汉堡
 */
public class VegBurger extends Burger{

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
