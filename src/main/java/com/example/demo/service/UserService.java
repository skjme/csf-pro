package com.example.demo.service;

import com.example.demo.controller.UserController;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    // 优先从缓存中加载
    @Cacheable(value="users", key="#userId")
    public User selectUserByCache(int userId) {
        logger.info("-----get data from db--------------");
        return userMapper.selectByPrimaryKey(userId);

    }

    // 从数据库中加载，无缓存查询
    public User selectUserByDB(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }


}
