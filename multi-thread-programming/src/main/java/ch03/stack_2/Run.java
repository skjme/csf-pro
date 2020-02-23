package ch03.stack_2;

public class Run {

    // 一个生成多个消费
    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        C c3 = new C(myStack);
        C c4 = new C(myStack);
        C c5 = new C(myStack);

        P_Thread p_thread = new P_Thread(p);
        C_Thread c_thread1 = new C_Thread(c1);
        C_Thread c_thread2 = new C_Thread(c2);
        C_Thread c_thread3 = new C_Thread(c3);
        C_Thread c_thread4 = new C_Thread(c4);
        C_Thread c_thread5 = new C_Thread(c5);

        p_thread.start();
        c_thread1.start();
        c_thread2.start();
        c_thread3.start();
        c_thread4.start();
        c_thread5.start();

    }
}
