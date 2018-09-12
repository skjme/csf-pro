package com.example.demo.dp.template;

public class TestTempateWorker {

    public static void main(String[] args) {
        Worker worker = new DabaojianWorker();
        worker.workTemplateMethod();

        Worker itWorker = new ItWorker();
        itWorker.workTemplateMethod();
    }
}
