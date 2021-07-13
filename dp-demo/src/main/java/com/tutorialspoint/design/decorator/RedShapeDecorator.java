package com.tutorialspoint.design.decorator;

public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedColor(decoratedShape);
    }

    private void setRedColor(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
