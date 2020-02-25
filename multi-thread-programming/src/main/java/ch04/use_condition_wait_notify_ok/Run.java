package ch04.use_condition_wait_notify_ok;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();

        Thread.sleep(3000);

        service.signal();
    }
}
