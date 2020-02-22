package ch03.notify_hold_lock;

public class Service {

    public void testMethod(Object lock){
        try{
            synchronized (lock){
                System.out.println("begin wait " + Thread.currentThread().getName()
                        + " time=" + System.currentTimeMillis());
                lock.wait();
                System.out.println("end wait " + Thread.currentThread().getName()
                        + " time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void synNotifyMethod(Object lock){
        try{
            synchronized (lock){
                System.out.println("begin notify " + Thread.currentThread().getName()
                + " time=" + System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("end notify " + Thread.currentThread().getName()
                + " time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
