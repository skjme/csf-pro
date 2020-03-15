package ch06.singleton_ok3;

public class Run {

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

    }
}
