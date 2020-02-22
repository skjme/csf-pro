package ch03.test1;

public class Test1 {

    public static void main(String[] args) {

        // 调用wait()前，当前线程务必要先获得当前对象的对象级别锁
        try{
            String newString = new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
