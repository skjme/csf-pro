package com.howtodoinjava.design.observer;

import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyUpdate(Message m) {
        for (Observer observer : this.observers) {
            observer.update(m);
        }
    }
}
