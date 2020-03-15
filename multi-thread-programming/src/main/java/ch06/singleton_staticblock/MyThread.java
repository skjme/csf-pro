package ch06.singleton_staticblock;

import java.util.stream.IntStream;

public class MyThread extends Thread {

    @Override
    public void run() {

        IntStream.range(0, 5).forEach(
                value -> {
                    System.out.println(MyObject.getInstance().hashCode());
                }
        );
    }
}
