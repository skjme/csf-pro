package ch03.stack_2;

public class P {

    private MyStack myStack;

    public P(MyStack myStack) {
        this.myStack = myStack;
    }

    public void pushService(){
        myStack.push();
    }
}
