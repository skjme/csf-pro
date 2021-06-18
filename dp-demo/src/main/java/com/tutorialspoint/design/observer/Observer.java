package com.tutorialspoint.design.observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
