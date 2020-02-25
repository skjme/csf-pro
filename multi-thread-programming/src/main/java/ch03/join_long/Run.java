package ch03.join_long;

public class Run {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();

            myThread.join(2000);
//            Thread.sleep(2000);

            System.out.println("  end timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
