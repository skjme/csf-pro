package com.tutorialspoint.design.observer;

public class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hexa String:" + Integer.toHexString(subject.getState()));
    }
}
