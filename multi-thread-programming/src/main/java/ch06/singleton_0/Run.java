package ch06.singleton_0;

import java.util.concurrent.atomic.AtomicLong;

public class Run {

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

//        AtomicLong
    }
}
