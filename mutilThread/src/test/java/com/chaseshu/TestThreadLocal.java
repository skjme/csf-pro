package com.chaseshu;

public class TestThreadLocal {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(
                () -> {
                    try {
                        for (int i = 0; i < 100; i++) {
                            threadLocal.set(i);
                            System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } finally {
                        threadLocal.remove();
                    }
                }
                , "threadLocal1").start();

        new Thread(
                () -> {
                    try {
                        for (int i = 0; i < 100; i++) {
                            System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } finally {
                        threadLocal.remove();
                    }
                }
                , "threadLocal2").start();
    }
}
