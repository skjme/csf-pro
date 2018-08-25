package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@RestController
@RequestMapping("/api")
public class TestController {
	
	private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Cacheable(value="users", key="#uid")
	@RequestMapping("user/{uid}")
    public User user(@PathVariable Integer uid){
        
		logger.info("get data from database ...");
		userMapper.selectByPrimaryKey(1);
		User u = new User();
		u.setUid(uid);
		u.setName("哈哈");
        return u;
    }

}
