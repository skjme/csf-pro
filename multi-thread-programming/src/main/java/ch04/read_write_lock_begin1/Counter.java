package ch04.read_write_lock_begin1;


import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用readWriteLock
 * 只允许一个线程写入（其他线程既不能写入也不能读取）；
 * 没有写入时，多个线程允许同时读（提高性能）
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306581002092578
 */
public class Counter {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock rLock = rwLock.readLock();
    private final Lock wLock = rwLock.writeLock();
    private int[] counts = new int[10];


    public void inc(int index){
        wLock.lock(); // 加写锁
        try{
            counts[index] += 1;
        }finally {
            wLock.unlock(); // 释放锁
        }
    }

    public int[] get(){
        rLock.lock(); // 加读锁
        try{
            return Arrays.copyOf(counts, counts.length);
        }finally {
            rLock.unlock(); // 释放锁
        }
    }
}
