package ch02.string;

public class Service {

    // 相同的字符串 同一把锁，出现死锁
//    public static void print(String StringParam){
//        try {
//            synchronized (StringParam) {
//                while (true) {
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(1000);
//                }
//            }
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//
    public static void print(Object object){
        try {
            synchronized (object) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
