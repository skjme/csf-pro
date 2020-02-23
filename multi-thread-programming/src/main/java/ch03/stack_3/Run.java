package ch03.stack_3;

public class Run {

    // 多个生成、一个消费
    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);
        P p4 = new P(myStack);
        P p5 = new P(myStack);
        C c1 = new C(myStack);


        P_Thread p_thread1 = new P_Thread(p1);
        P_Thread p_thread2 = new P_Thread(p2);
        P_Thread p_thread3 = new P_Thread(p3);
        P_Thread p_thread4 = new P_Thread(p4);
        P_Thread p_thread5 = new P_Thread(p5);
        C_Thread c_thread1 = new C_Thread(c1);


        c_thread1.start();
        p_thread1.start();
        p_thread2.start();
        p_thread3.start();
        p_thread4.start();
        p_thread5.start();

    }
}
