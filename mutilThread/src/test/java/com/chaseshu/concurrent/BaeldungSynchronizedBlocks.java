package com.chaseshu.concurrent;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaeldungSynchronizedBlocks {
 
    private int count = 0;

    // 3 Synchronized Blocks within Methods
    public void performSynchrinisedTask() {
        synchronized (this) {
            setCount(getCount()+1);
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Test
    public void givenMultiThread_whenBlockSync() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        BaeldungSynchronizedBlocks synchronizedBlocks = new BaeldungSynchronizedBlocks();

        IntStream.range(0, 1000)
                .forEach(count ->
                        service.submit(synchronizedBlocks::performSynchrinisedTask));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, synchronizedBlocks.getCount());
    }
}