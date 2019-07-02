package cn.chaseshu.shardingjdbcmasterslave.service;

import cn.chaseshu.shardingjdbcmasterslave.entity.User;

import java.util.List;

public interface UserService {

    Long addUser(User user);

    List<User> list();
}
