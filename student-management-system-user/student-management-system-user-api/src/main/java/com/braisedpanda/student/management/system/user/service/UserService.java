package com.braisedpanda.student.management.system.user.service;

import com.braisedpanda.student.management.system.user.model.po.User;


import java.util.List;

public interface UserService {

    //查找所有的用户
    List<User> listUsers();

    //添加用户
    void insertUser(User user);

    //根据用户名和密码查找用户
    User selectUserByUsernameAndPasword(String username, String password);

    //删除用户
    void deleteUser(User user);

    //根据uid查找用户
    User getUserById(User user);

    //更新用户信息
    void updateUserById(User user);
    //统计用户人数
    int countUser();
}
