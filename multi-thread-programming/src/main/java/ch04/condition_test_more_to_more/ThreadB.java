package ch04.condition_test_more_to_more;

public class ThreadB extends Thread {

    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while(true){
            service.get();
        }
    }
}
