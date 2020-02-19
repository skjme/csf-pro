package ch02.volatile1.t10;


public class Run {

    // 工作内存 share空间 主内存
    public static void main(String[] args) {
        PrintString printString = new PrintString();
        new Thread(printString).start();

        System.out.println("我要停止它！ stopThread=" + Thread.currentThread().getName());
        printString.setContinuePrint(false); //
    }
}
