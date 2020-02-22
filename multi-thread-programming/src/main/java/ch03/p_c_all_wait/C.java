package ch03.p_c_all_wait;

// 消费者
public class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue(){
        try{
            synchronized (lock){
                if(ValueObject.value.equals("")){
                    System.out.println("消费喝" + Thread.currentThread().getName() +"WAITING了");

                    lock.wait();
                }
                System.out.println("消费者" + Thread.currentThread().getName() +"RUNNABLE了");

                System.out.println("get value=" + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
//                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
