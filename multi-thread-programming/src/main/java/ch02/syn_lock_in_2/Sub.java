package ch02.syn_lock_in_2;

public class Sub extends Main{

    // 当存在父子继承关系时，子类可以通过『可重入锁』调用父类的同步方法
    synchronized public void operateISubMethod(){
        try {
            while(i > 0){
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(500);

                this.operateIMainMethod();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
