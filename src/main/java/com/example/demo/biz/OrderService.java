package com.example.demo.biz;

import com.example.demo.lock.ZookeeperImproveLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟高并发创建订单
 */
public class OrderService implements Runnable{

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private OrderNumFactory onf = new OrderNumFactory();

    private final static int count = 100;
    private final static CountDownLatch cdi = new CountDownLatch(count);

    private final Lock lock = new ReentrantLock();
//    private final Lock lock = new ZookeeperImproveLock();//分布式锁 distributed lock

    @Override
    public void run() {

        try {
            cdi.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        createOrderNum();
    }

    public void createOrderNum(){

        lock.lock();
        try{
            String orderNum = onf.createOrderNum();
            logger.info(Thread.currentThread().getName() +  "--->创建订单号：【"+ orderNum +"】");
        }catch (Exception ex){

        }finally {
            lock.unlock();
        }


    }
}
