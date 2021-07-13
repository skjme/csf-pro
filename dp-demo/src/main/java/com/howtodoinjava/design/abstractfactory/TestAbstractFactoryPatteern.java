package com.howtodoinjava.design.abstractfactory;

public class TestAbstractFactoryPatteern {

    public static void main(String[] args) {

        System.out.println(CarFactory.buildCar(CarType.SMALL));

        System.out.println(CarFactory.buildCar(CarType.SEDAN));

        System.out.println(CarFactory.buildCar(CarType.LUXURY));
    }
}
