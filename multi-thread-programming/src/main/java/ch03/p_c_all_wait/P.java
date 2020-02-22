package ch03.p_c_all_wait;

// 生产者
public class P {

    private String lock;

    public P(String lock) {
        this.lock = lock;
    }

    public void setValue(){
        try{
            synchronized (lock){
                while(!ValueObject.value.equals("")){
                    System.out.println("生产者" + Thread.currentThread().getName() +"WAITING了");
                    lock.wait();
                }
                System.out.println("生产者" + Thread.currentThread().getName() +"runnable了");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set value=" + value);
                ValueObject.value = value;
                lock.notify();
//                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
