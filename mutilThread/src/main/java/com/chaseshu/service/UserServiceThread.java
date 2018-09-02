package com.chaseshu.service;

import com.alibaba.fastjson.JSONObject;
import com.chaseshu.util.concurrent.MyFutureTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Component
public class UserServiceThread {

    Logger logger = LoggerFactory.getLogger(UserServiceThread.class);

    @Autowired
    private RestTemplate restTemplate;

    public JSONObject getUserInfo(final String userId) throws ExecutionException, InterruptedException {

        // 1. 通过callable 封装业务逻辑

        Callable<JSONObject> userInfoCallable = new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                // 1,调用获取用户基础信息的接口.
                long userInfoTime = System.currentTimeMillis();
                String value = restTemplate.getForObject("http://localhost:8088/userinfo-api/get?userId=" + userId, String.class);

                JSONObject userInfo = JSONObject.parseObject(value);
                logger.error("userinfo-api用户基本信息接口调用时间为" + (System.currentTimeMillis() - userInfoTime));

                return userInfo;
            }
        };

        Callable<JSONObject> integralCallable = new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {

                // 2. 调用获取用户积分信息的接口
                long integralApiTime = System.currentTimeMillis();
                String integral = restTemplate.getForObject("http://localhost:8088/integral-api/get?userId=" + userId, String.class);
                JSONObject integralInfo = JSONObject.parseObject(integral);
                logger.error("integral-api用户基本信息接口调用时间为" + (System.currentTimeMillis() - integralApiTime));

                return integralInfo;
            }
        };

        // 2. futureTask 封装callable
//        FutureTask<JSONObject> userinfoFutureTask = new FutureTask<JSONObject>(userInfoCallable);// 官方实现
//        FutureTask<JSONObject> integralInfoFutureTask = new FutureTask<JSONObject>(integralCallable);
        MyFutureTask<JSONObject> userinfoFutureTask = new MyFutureTask<JSONObject>(userInfoCallable);// 自定义简单实现
        MyFutureTask<JSONObject> integralInfoFutureTask = new MyFutureTask<JSONObject>(integralCallable);


        // 3. 线程执行
        new Thread(userinfoFutureTask).start();
        new Thread(integralInfoFutureTask).start();

        // 4. 合并为一个json对象
        JSONObject result = new JSONObject();
        // 此处等待结果（没有执行完毕，则阻塞线程，等待结果，如果线程task执行完毕，则立即返回结果）
        result.putAll(userinfoFutureTask.get());
        result.putAll(integralInfoFutureTask.get());

        return  result;
    }
}
