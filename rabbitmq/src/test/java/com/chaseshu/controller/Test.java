package com.chaseshu.controller;

import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Stream
                .of(1,2,3,4,5)
                .map(String::valueOf)
                .forEach(System.out::println);

        System.exit(128);
    }
}
