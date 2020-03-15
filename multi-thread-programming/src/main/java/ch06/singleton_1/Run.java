package ch06.singleton_1;

public class Run {

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

        // 多线程的环境下，可能出现多个实例
    }
}
