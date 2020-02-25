package ch04.use_more_condition_ok;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        new ThreadA(service).start();
        new ThreadB(service).start();

        Thread.sleep(3000);

        service.signalAll_A();
    }
}
