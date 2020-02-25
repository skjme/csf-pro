package ch04.condition_test_more_to_more;

public class ThreadA extends Thread {

    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while(true){
            service.set();
        }
    }
}
