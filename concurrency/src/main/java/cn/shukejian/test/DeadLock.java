package cn.shukejian.test;

public class DeadLock {
       byte[] lock1 = new byte[0];
       byte[] lock2 = new byte[0];
       void f1() throws InterruptedException {
           synchronized (lock1){
               Thread.sleep(1000);
               synchronized (lock2){
                   System.out.println("f1");
               }
} }
       void f2() throws InterruptedException {
           synchronized (lock2){
               Thread.sleep(1000);
               synchronized (lock1){
                   System.out.println("f2");
               }
} }
       public static void main(String[] args) {
           
           DeadLock deadLock = new DeadLock();
           new Thread(() -> {
               try {
                   deadLock.f1();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }).start();
           
           new Thread(() -> {
               try {
                   deadLock.f2();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }).start();
       }
}
