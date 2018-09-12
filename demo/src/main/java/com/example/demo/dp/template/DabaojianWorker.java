package com.example.demo.dp.template;

public class DabaojianWorker extends Worker {


    @Override
    public void beforeWork() {
        System.out.println("洗手。。。。。");
    }

    @Override
    public void doingWork() {
        System.out.println("。按摩。。。。");
    }

    @Override
    public void afterWork() {
        System.out.println("洗干净。。。。。");
    }
}
