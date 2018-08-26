package com.example.demo.lock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ZookeeperImproveLock implements Lock {

    private static Logger logger = LoggerFactory.getLogger(ZookeeperImproveLock.class);

    private static final String LOCK_PATH = "/LOCK";

//    private static final String ZOOKEEPER_IP_PORT = "192.168.56.101:2181";
    private static final String ZOOKEEPER_IP_PORT = "localhost:2181";

    private ZkClient client = new ZkClient(ZOOKEEPER_IP_PORT, 5000, 5000, new SerializableSerializer());

    private CountDownLatch cdi;

    private String beforePath;
    private String currentPath;

    //判斷有沒有LOCK目錄，沒有就創建
    public ZookeeperImproveLock(){
        if(!this.client.exists(LOCK_PATH)){
            this.client.createPersistent(LOCK_PATH);
        }
    }

    @Override
    public boolean tryLock() {

        //如果currentPath為空則為第一次嘗試加鎖，第一次加鎖賦值currentPath
        if(currentPath == null || currentPath.length() <= 0){
            //創建一個臨時順序節點
            currentPath = this.client.createEphemeralSequential(LOCK_PATH + "/" , "lock");
            System.out.println("------------------------------------->" + currentPath);
        }

        //獲取所有临时节点并排序，临时节点名称为为自增长的字符串 如：0000000400
        List<String> childrens = this.client.getChildren(LOCK_PATH);
        Collections.sort(childrens);

        if(currentPath.equals(LOCK_PATH + "/" + childrens.get(0))){
            //如果当前节点在所有及诶单中排名第一则获锁成功
            return true;
        }else{

            //如果当前节点在所有及诶单中排名中不是排名第一， 则获取前面的节点名称，并赋值给beforePath
            int wz = Collections.binarySearch(childrens, currentPath.substring(6));
            beforePath = LOCK_PATH +"/" + childrens.get(wz-1);
        }
        return false;
    }

    @Override
    public void unlock() {

        //删除当前临时节点
        this.client.delete(currentPath);

    }

    @Override
    public void lock() {

        if(!tryLock()){
            waitForLock();
            lock();
        }else{
            logger.info(Thread.currentThread().getName() + "获得分布式锁");
        }
    }

    private void waitForLock() {

        IZkDataListener listener = new IZkDataListener() {

            @Override
            public void handleDataDeleted(String s) throws Exception {
                logger.info(Thread.currentThread().getName() + "：捕获到DataDelete事件！");
                if(cdi!=null){
                    cdi.countDown();
                }
            }

            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

        };

        //给排在前面的节点增加数据删除的watcher
        this.client.subscribeDataChanges(beforePath, listener);

        if(this.client.exists(beforePath)){
            cdi = new CountDownLatch(1);
            try {
                cdi.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.client.unsubscribeDataChanges(beforePath, listener);

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