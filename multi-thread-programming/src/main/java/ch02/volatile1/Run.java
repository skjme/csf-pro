package ch02.volatile1;

public class Run {

    // 工作内存 share空间 主内存
    public static void main(String[] args) {
        PrintString printString = new PrintString();
        printString.printString();// 死循环啦

        System.out.println("我要停止它！ stopThread=" + Thread.currentThread().getName());
        printString.setContinuePrint(false); //
    }
}
