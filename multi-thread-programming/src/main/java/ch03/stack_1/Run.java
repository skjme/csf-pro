package ch03.stack_1;

public class Run {

    // 一个生产/一个消费
    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c = new C(myStack);
        P_Thread p_thread = new P_Thread(p);
        C_Thread c_thread = new C_Thread(c);

        p_thread.start();
        c_thread.start();

    }
}
