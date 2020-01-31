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
public class BaeldungSynchronizedMethods {
 
    private int sum = 0;

    private static int staticSum = 0;
 
    public void calculate() {
        setSum(getSum() + 1);
    }

    // 1 Synchronized Instance Methods
    public synchronized void synchronizsedCalculate() {
        setSum(getSum() + 1);
    }

    // 2 Synchronized Static Methods
    public static synchronized void syncStaticCalculate() {
        staticSum = staticSum + 1;
    }

    // 3 Synchronized Blocks within Methods
    public void performSynchrinisedTask() {
        synchronized (this) {
            setSum(getSum()+1);
        }
    }

    // standard setters and getters

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    @Test
    public void giveMultiThread_whenNoSyncMethod() throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);

        BaeldungSynchronizedMethods summation = new BaeldungSynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::calculate));

        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, summation.getSum());


    }

    @Test
    public void giveMultiThread_whenSyncMethod() throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);

        BaeldungSynchronizedMethods summation = new BaeldungSynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::synchronizsedCalculate));

        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, summation.getSum());

    }

    @Test
    public void giveMultiThread_whenStaticSyncMethod() throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);


        IntStream.range(0, 1000)
                .forEach(count -> service.submit(BaeldungSynchronizedMethods::syncStaticCalculate));

        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, BaeldungSynchronizedMethods.staticSum);

    }

    @Test
    public void givenMultiThread_whenBlockSync() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        BaeldungSynchronizedMethods synchronizedBlocks = new BaeldungSynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count ->
                        service.submit(synchronizedBlocks::performSynchrinisedTask));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, synchronizedBlocks.getSum());
    }
}