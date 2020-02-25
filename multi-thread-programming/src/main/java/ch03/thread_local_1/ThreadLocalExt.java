package ch03.thread_local_1;

public class ThreadLocalExt extends ThreadLocal {

    @Override
    protected Object initialValue() {

        return "我是默认值";
    }

    public static void main(String[] args) {

        ThreadLocalExt threadLocalExtTest = new ThreadLocalExt();

        System.out.println(threadLocalExtTest.get());

    }
}
