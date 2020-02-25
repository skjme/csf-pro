package ch04.condition_test;

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
