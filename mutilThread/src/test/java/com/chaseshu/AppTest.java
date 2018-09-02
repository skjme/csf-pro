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
}
