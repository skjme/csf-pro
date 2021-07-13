package com.howtodoinjava.design.strategy;

public class Demo {

    public static void main(String[] args) {

        // Creating social Media Connect Object for connecting with friend by
        // any social media strategy
        SocialMediaContext context = new SocialMediaContext();

        // Setting Facebook strategy
        context.setSocialMediaContext(new FacebookStrategy());
        context.connect("chaseshu");

        System.out.println("=============");

        // Setting Twitter strategy
        context.setSocialMediaContext(new TwitterStrategy());
        context.connect("chaseshu");

        System.out.println("=============");

        // Setting GooglePlus strategy
        context.setSocialMediaContext(new GooglePlusStrategy());
        context.connect("chaseshu");

        System.out.println("=============");


    }
}
