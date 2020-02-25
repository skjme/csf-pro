package ch04.condition_test_more_method;

public class ThreadAA extends Thread {

    private MyService myService;

    public ThreadAA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethodA();
    }
}
