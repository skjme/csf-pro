package com.tutorialspoint.design.builder;

/**
 * 蔬菜汉堡
 */
public class ChickenBurger extends Burger{

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
