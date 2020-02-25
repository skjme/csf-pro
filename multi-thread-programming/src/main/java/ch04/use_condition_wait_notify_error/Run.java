package ch04.use_condition_wait_notify_error;

public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();
        new ThreadA(service).start();

        // throws IllegalMonitorStateException 无监视器对象
    }
}
