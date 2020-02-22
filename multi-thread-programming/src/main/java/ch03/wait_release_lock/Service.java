package ch03.wait_release_lock;

public class Service {

    public void testMethod(Object lock){
        try{
            synchronized (lock){
                System.out.println("begin wait " + Thread.currentThread().getName());
                lock.wait();
                System.out.println("end wait " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
