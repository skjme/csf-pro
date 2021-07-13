package com.howtodoinjava.design.strategy;

public class SocialMediaContext {

    ISocialMediaStrategy smStrategy;

    public void setSocialMediaContext(ISocialMediaStrategy smStrategy) {
        this.smStrategy = smStrategy;
    }

    public void connect(String name){
        smStrategy.connectTo(name);
    }
}
