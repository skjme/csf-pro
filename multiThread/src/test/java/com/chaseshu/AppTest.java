package com.chaseshu;


import com.alibaba.fastjson.JSONObject;
import com.chaseshu.service.UserService;
import com.chaseshu.service.UserServiceThread;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.print.DocFlavor;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.LockSupport;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceThread userServiceThread;

    @Before
    public void before(){
        System.out.println("调用开始");
    }

    @After
    public void end(){
        System.out.println("调用结束");
    }


    @Test
    public void testUserService()
    {

        long currentTimeMillis = System.currentTimeMillis();
        JSONObject userInfo = userService.getUserInfo("lisi");
        logger.error("userinfo = {}" ,userInfo);

        logger.error("getUserInfo调用时间为" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /**
     * 使用多线程方式调用
     */
    @Test
    public void testUserServiceByMultiThread()
    {

        long currentTimeMillis = System.currentTimeMillis();
        final String userId = "list";
        JSONObject userInfo = null;
        try {
            userInfo = userServiceThread.getUserInfo(userId);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.error("userinfo = {}" ,userInfo);

        logger.error("getUserInfo调用时间为" + (System.currentTimeMillis() - currentTimeMillis));
    }


    /**
     * Park/Unpark
     * 针对线程操作：阻塞和唤醒  区别Warit/Notify 面向Object，非Thread
     * park和unpark无顺序要求    区别：先wait，再notify
     * 针对指定线程进行唤醒      区别NotifyAll可以唤醒多个线程
     */
    @Test
    public void testParkAndUnpark() throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 通知
                System.out.println("先通知");
                LockSupport.unpark(thread);
            }
        }).start();

        thread = Thread.currentThread();
        Thread.sleep(2000L);
        System.out.println("等待");
        LockSupport.park(thread);//wait
        System.out.println("XXXXXXXXOOOOOOOOOO");
    }

    @Test
    public void testParkAndUnpark2() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 通知
                System.out.println("通知");
                LockSupport.unpark(thread);
            }
        }).start();

        thread = Thread.currentThread();
        System.out.println("先等待");
        LockSupport.park(thread);//wait
        System.out.println("XXXXXXXXOOOOOOOOOO");
    }

    static Thread thread = null;
}
