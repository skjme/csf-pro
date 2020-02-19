package ch02.syn_lock_in_1;

public class Service {

    // 可重入锁 自己可以再次进入自己的内部锁
    synchronized public void service1(){
        System.out.println("service1");
        service2();
    }

    synchronized public void service2(){
        System.out.println("service2");
        service3();
    }

    synchronized public void service3(){
        System.out.println("service3");
    }
}
