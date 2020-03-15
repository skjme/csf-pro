package ch06.singleton_ok2;

public class Run {

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

        // synchronized 性能低下
    }
}
