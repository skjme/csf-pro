package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Cacheable(value="users", key="#uid")
	@RequestMapping("user/{uid}")
    public User user(@PathVariable Integer uid){
        
		logger.info("get data from database ...");
		User u = userMapper.selectByPrimaryKey(1);

        return u;
    }
	
	@CacheEvict(value="users", key="#uid") //根据主键更新
	@RequestMapping("updateUser/{uid}")
	public User udpateUser(@PathVariable Integer uid){
		
		logger.info("update data from database ...");
		User u = userMapper.selectByPrimaryKey(1);
		u.setUserName("chaseshu-"+System.currentTimeMillis());
		userMapper.updateByPrimaryKeySelective(u);
		u = userMapper.selectByPrimaryKey(1);
		return u;
	}

}
