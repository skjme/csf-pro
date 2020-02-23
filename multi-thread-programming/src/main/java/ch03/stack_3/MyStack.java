package ch03.stack_3;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private List list = new ArrayList();

    synchronized public void push(){
        try{
            while (list.size() == 1){ // 注意这里不是if而是while， 避免多个呈wait状态的状态被唤醒
                this.wait();
            }

            list.add("anyString=" + Math.random());
            this.notifyAll(); // 防止假死
            System.out.println("push=" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop(){
        String returnValue = "";
        try{
            while (list.size() == 0){ // 注意这里不是if而是while， 避免多个呈wait状态的状态被唤醒
                System.out.println("pop操作中的：" + Thread.currentThread().getName()
                + " 线程呈wait状态");
                this.wait();
            }
            returnValue = "" + list.get(0);
            list.remove(0);
            this.notifyAll(); // 防止假死
            System.out.println("pop=" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
