package concurrent.jcip;

import java.util.concurrent.TimeUnit;

public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready){
                //Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ready + " " + number);

        new ReaderThread().start();

        TimeUnit.SECONDS.sleep(3);

        number = 42;
        ready = true;
    }
}
