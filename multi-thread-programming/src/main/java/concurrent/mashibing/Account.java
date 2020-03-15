package concurrent.mashibing;

import java.util.concurrent.TimeUnit;

/**
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题（dirtyRead）
 */
public class Account {

    private String name;
    private double balance;

    public synchronized void set(String name, double balance){
        this.name = name;

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    synchronized public double getBalance(String name){
//    public double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                a.set("zhangsan", 1000);
//            }
//        }).start();
        new Thread(()->a.set("zhangsan", 1000)).start(); // 等价以上代码

        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));

        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));

    }
}
