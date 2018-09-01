//package com.chaseshu.service;
//
//
//import java.util.concurrent.*;
//
//public class MyFutureTask<T> implements Runnable, Future<T> {
//
//    Logger logger = Logger.getLogger(Sender.class);
//
//    Callable<T> callable;
//
//    T result;
//
//    String state = "NEW";
//
//
//    public MyFutureTask(Callable<T> callable){
//        this.callable = callable;
//    }
//
//    @Override
//    public void run() {
//
//        try {
//            result = callable.call();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            state = "END";
//        }
//
//        logger.info(Thread.currentThread().getName() + " 执行完毕，通知主线程");
//
//        // 没有执行完毕，则阻塞线程（Main 主线程），等待结果（执行完毕）
//        synchronized (this){
//            this.notifyAll();
//        }
//    }
//
//    @Override
//    public boolean cancel(boolean mayInterruptIfRunning) {
//        return false;
//    }
//
//    @Override
//    public boolean isCancelled() {
//        return false;
//    }
//
//    @Override
//    public boolean isDone() {
//        return false;
//    }
//
//    @Override
//    public T get() throws InterruptedException, ExecutionException {
//
//        if("END".equals(state)){
//            return result;
//        }
//
//        Thread currentThread = Thread.currentThread();
//        logger.info(currentThread.getName() + " 没有结果，进入等待");
//
//        synchronized (this){
//            this.wait();
//        }
//
//        return result;
//    }
//
//    @Override
//    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
//        return null;
//    }
//}
