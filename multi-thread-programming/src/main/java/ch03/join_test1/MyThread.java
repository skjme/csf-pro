package ch03.join_test1;

public class MyThread extends Thread {

    @Override
    public void run() {

        try{
            int secondeValue = (int) (Math.random() * 10000);
            System.out.println(secondeValue);
            Thread.sleep(secondeValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
