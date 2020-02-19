package ch02.synchronized_method_lock_object;

import ch02.two_object_two_lock.ThreadA;

public class MyObject {

   synchronized public void methodA(){
        try {
            System.out.println("begin methodA threadName=" + ThreadA.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
