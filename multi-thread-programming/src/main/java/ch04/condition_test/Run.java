package ch04.condition_test;

/**
 * 实现生产/消费者模式：一对一交替打印
 */
public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();
        new ThreadA(service).start();
        new ThreadB(service).start();

    }
}
