package cn.chaseshu;

import cn.chaseshu.domain.User;
import cn.chaseshu.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1(){

        final User user = userRepository.save(new User("u1", "p1"));
        log.debug("[添加成功] - [{}]", user);

        final User edit = userRepository.save(new User(user.getId(), "修改后的ui", "修改后的p1"));
        log.info("[修改成功] - [{}]", edit);

        userRepository.deleteById(user.getId());
        log.info("[删除主键为 {} 成功] - [{}]", user.getId());

    }

    @Test
    public void test2(){

        final List<User> u1 = userRepository.findAllByUsername("u1");
        log.info("[条件查询] - [{}]", u1);

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("username")));
        final Page<User> users = userRepository.findAll(pageable);
        log.info("[分页+排序+查询所有] - [{}]", users.getContent());


        userRepository.findById(users.getContent().get(0).getId()).ifPresent(user1 -> log.info("[主键查询] - [{}]", user1));



    }


}
