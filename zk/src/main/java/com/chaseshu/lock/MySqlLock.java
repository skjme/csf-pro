package com.chaseshu.lock;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MySqlLock implements Lock {

    private static final int LOCK_NUM = 1;

    @Resource
    private LockMapper lockMapper;

    //阻塞式的实现
    @Override
    public void lock() {

        if(!tryLock()){
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock();
        }
    }

    //非阻塞式的实现
    @Override
    public boolean tryLock() {

        try {
            lockMapper.insert(LOCK_NUM);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void unlock() {
        lockMapper.deleteByPrimaryKey(LOCK_NUM);
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
