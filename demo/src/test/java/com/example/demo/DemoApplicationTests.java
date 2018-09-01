package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
//		userMapper.selectAllUser();
		userMapper.selectByPrimaryKey(1);
	}
	
	@Test
	public void create() {

		User u = new User();
		u.setUserId(1);
		u.setUserName("chaseshu");
		u.setPassword("123456");
		u.setPhone("13621714400");
		
		userMapper.insert(u);
		
	}

}
