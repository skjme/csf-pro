package concurrent.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Test {

    // 并发编程的本质：充分利用CPU

    public static void main(String[] args) {

        // get cpu的核数
        System.out.println(Runtime.getRuntime().availableProcessors());

//        Thread.State;

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println(executorService);
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        System.out.println(executorService1);
        ExecutorService executorService2 = Executors.newCachedThreadPool();


//        ForkJoinPool

    }
}
