package ch06.singleton_staticblock;

public class Run {

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}
