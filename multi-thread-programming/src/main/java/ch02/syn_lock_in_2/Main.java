package ch02.syn_lock_in_2;

public class Main {

    public int i = 10;
    synchronized public void operateIMainMethod(){
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
