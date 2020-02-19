package ch02.volatile1;

public class PrintString {

    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printString(){
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

}
