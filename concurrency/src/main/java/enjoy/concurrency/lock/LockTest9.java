package enjoy.concurrency.lock;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "enjoy")
public class LockTest9 {

   static int k=0;

    public static void main(String[] args) {
        waitNofity waitNofity = new waitNofity();

        new Thread(() -> {
            try {
                waitNofity.print(k+"",1,2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();


        new Thread(() -> {
            try {
                waitNofity.print(k+"",2,3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();




        new Thread(() -> {
            try {
                waitNofity.print(k+"",3,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3").start();



    }
        //et t2  t3
        //

    static class waitNofity{

        int flag=1;

        public void print(String content,int waitFlag,int nextFlag) throws InterruptedException {
            for (int i = 0; i <4 ; i++) {
                synchronized (this){
                    while (flag!= waitFlag){
                        this.wait();
                    }
                    System.out.print(content);
                    k++;
                    flag= nextFlag;
                    this.notifyAll();
                }
                if(waitFlag==3){
                    System.out.print(" ");
                }
            }

        }
    }
}
