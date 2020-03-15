package ch06.singleton_enum;

import java.util.stream.IntStream;

public class MyThread extends Thread {

    @Override
    public void run() {

        IntStream.range(0, 5).forEach(
                value -> {
                    System.out.println(MyObject.getConnection().hashCode());
                }
        );
    }
}
