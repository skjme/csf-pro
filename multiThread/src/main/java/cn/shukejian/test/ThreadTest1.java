package cn.shukejian.test;

/**
 * 使用多线程踩的“坑”——使用多线程真会使用CPU所有的内核吗？
 * @linkurl https://www.jianshu.com/p/352caffd6366
 */
public class ThreadTest1 {

    private static final int num = 1000 * 1000;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            for (int i = 0; i < num; i++) {
                System.out.println(i);
            }
        },"线程1").start();

        new Thread(()->{
            for (int i = 0; i < num; i++) {
                System.out.println(i);
            }
        },"线程2").start();

        new Thread(()->{
            for (int i = 0; i < num; i++) {
                System.out.println(i);
            }
        },"线程3").start();

        new Thread(()->{
            for (int i = 0; i < num; i++) {
                System.out.println(i);
            }
        },"线程4").start();
    }
}