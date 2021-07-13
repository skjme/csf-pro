package com.tutorialspoint.design.abstractfactory;

public class ShapeFactory extends AbstractFactory{

    @Override
    Shape getShape(String shareType) {
        if(shareType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shareType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;
    }

}
