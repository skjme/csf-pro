package ch03.stack_2;

public class C {

    private MyStack myStack;

    public C(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService(){
        System.out.println("pop=" + myStack.pop());
    }
}
