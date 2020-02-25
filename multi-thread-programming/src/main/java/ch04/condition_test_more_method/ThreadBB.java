package ch04.condition_test_more_method;

public class ThreadBB extends Thread {

    private MyService myService;

    public ThreadBB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethodB();
    }
}
