package ch03.wait_old;


public class Subtract {

    private String lock;

    public Subtract(String lock) {
        this.lock = lock;
    }

    public void subtract(){

        try {
            synchronized (lock) {
//                if(ValueObject.list.size() == 0){
                while(ValueObject.list.size() == 0){
                    System.out.println("wait begin time = " + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end time = " + System.currentTimeMillis()
                            + " ThreadName=" + Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("list size=" + ValueObject.list.size()
                        + " ThreadName=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
