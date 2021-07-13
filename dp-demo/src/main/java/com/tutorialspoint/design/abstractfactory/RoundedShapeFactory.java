package com.tutorialspoint.design.abstractfactory;

public class RoundedShapeFactory extends AbstractFactory{
    @Override
    Shape getShape(String shareType) {
        if(shareType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        }else if(shareType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }
        return null;
    }
}
