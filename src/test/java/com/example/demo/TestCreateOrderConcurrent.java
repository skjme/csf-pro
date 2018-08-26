package com.example.demo;

import com.example.demo.biz.OrderNumFactory;
import com.example.demo.biz.OrderService;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCreateOrderConcurrent {

    private final Logger logger = LoggerFactory.getLogger(TestCreateOrderConcurrent.class);

    //并发的用户数（同时并发的线程数）
    private final static int threadNum = 100;
    // 倒计数器（发令枪），用于制造线程的并发执行
    private final static CountDownLatch cdl = new CountDownLatch(threadNum);

    //
    private OrderNumFactory onf = new OrderNumFactory();

    @Resource
    private UserService userService;

    private static final int userId = 1;

    @Before
    public void init() {
        logger.info("-----------------init start----------------------");
        User user = userService.selectUserByCache(userId);
        logger.info(Thread.currentThread().getName() + "--->【" + user.getUserId() + "】");
        logger.info("-----------------init over----------------------");
    }

    /**
     * 主要测试方法
     */
    @Test
    public void crashTest() throws InterruptedException {

        //循环threadNum次，实例化threadNum个线程，并同时执行
        for (int i = 0; i < threadNum; i++) {
            new Thread(new UserRequest()).start();
            cdl.countDown();
        }

        // 主线程挂起，等子线程执行完后
        Thread.currentThread().join();

    }

    // 模拟用户的请求,继承实现线程接口
    private class UserRequest implements Runnable {

        @Override
        public void run() {
            try {
                //所有子线程在这里等待，当所有线程实例化后，同时停止等待
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //N个子线程同时调用业务接口
//            String orderNum = onf.createOrderNum();
//            logger.info(Thread.currentThread().getName() +  "--->创建订单号：【"+ orderNum +"】");
            User user = userService.selectUserByCache(userId);
//            User user = userService.selectUserByDB(userId);
            logger.info(Thread.currentThread().getName() + "--->【" + user.getUserId() + "】");

        }
    }


}
