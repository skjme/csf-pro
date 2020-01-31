package com.chaseshu.service;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RestTemplate restTemplate;

    public JSONObject getUserInfo(String userId){

        // 1,调用获取用户基础信息的接口
        long userInfoTime = System.currentTimeMillis();
        String value = restTemplate.getForObject("http://localhost:8088/userinfo-api/get?userId=" + userId, String.class);

        JSONObject userInfo = JSONObject.parseObject(value);
        logger.error("userinfo-api用户基本信息接口调用时间为" + (System.currentTimeMillis() - userInfoTime));


        // 2. 调用获取用户积分信息的接口
        long integralApiTime = System.currentTimeMillis();
        String integral = restTemplate.getForObject("http://localhost:8088/integral-api/get?userId=" + userId, String.class);
        JSONObject integralInfo = JSONObject.parseObject(integral);
        logger.error("integral-api用户基本信息接口调用时间为" + (System.currentTimeMillis() - integralApiTime));


        // 3 合并为一个json对象
        JSONObject result = new JSONObject();
        result.putAll(userInfo);
        result.putAll(integralInfo);

        return  result;
    }
}
