package ch04.condition_test_more_method;

public class ThreadB extends Thread {

    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethodB();
    }
}
