package ch02.volatile1.t10;

public class PrintString implements Runnable {

    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod(){
        try{
            while(isContinuePrint){
                System.out.println("run printString threadName=" +
                        Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void run() {
        printStringMethod();
    }
}
