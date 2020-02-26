package ch04.lock_interruptibly_test1;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        final MyService service = new MyService();
        Runnable runnable = new Runnable() {
            public void run() {
                service.waitMethod();
            }
        };

        Thread t1 = new Thread(runnable);
        t1.setName("A");
        t1.start();
        Thread.sleep(5000);

        Thread t2 = new Thread(runnable);
        t2.setName("B");
        t2.start();

        t2.interrupted();

        System.out.println("main end");
    }
}
