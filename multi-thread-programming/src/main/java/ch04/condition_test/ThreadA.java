package ch04.condition_test;

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
