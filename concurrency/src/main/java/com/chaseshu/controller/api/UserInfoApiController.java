package com.chaseshu.controller.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoApiController {


    @RequestMapping("userinfo-api/get")
    public JSONObject userinfo(@RequestParam String userId){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        JSONObject user = new JSONObject();
        user.put("userId", userId);
        user.put("name", "李四");

        return  user;
    }

    @RequestMapping("integral-api/get")
    public JSONObject integral(@RequestParam String userId){

        try {
            Thread.sleep(2200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JSONObject integral = new JSONObject();
        integral.put("userId", userId);
        integral.put("integral", 2000);

        return  integral;
    }
}
