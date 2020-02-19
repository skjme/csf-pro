package ch02.volatile1.volatile_test_thread;

public class MyThread extends Thread {

     public static int count;

    // 静态方法锁 类class级锁
    synchronized private static void addCount(){
        for(int i = 0; i < 1000; i++){
            count++;
        }
        System.out.println("count=" + count);
    }

//    volatile public static int count;
//
//    // 静态方法锁 类class级锁
//    synchronized private static void addCount(){
//        for(int i = 0; i < 1000; i++){
//            count++;
//        }
//        System.out.println("count=" + count);
//    }

    @Override
    public void run() {
        super.run();
        addCount();
    }
}
