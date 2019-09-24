package com.braisedpanda.student.management.system.user.service;



import com.braisedpanda.student.management.system.commons.utils.PageHelperUtils;

import com.braisedpanda.student.management.system.user.mapper.UserMapper;
import com.braisedpanda.student.management.system.domain.model.User;

import com.github.pagehelper.PageHelper;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    /**
    * @Description: 查找所有的用户
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public List<User> listUsers() {

        List<User> userList = userMapper.selectAll();
        return userList;

    }

    /**
    * @Description: 新增用户
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public void insertUser(User user) {
        userMapper.insert(user);

    }


    /**
    * @Description: 根据用户名和密码查找用户
    * @Param:  username:用户名  password:密码
    * @return:
    * @Date: 2019/8/22 0022
    */

    public User selectUserByUsernameAndPasword(String username, String password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("password",password);

        User user =userMapper.selectOneByExample(example);
            return user;
    }

    /**
    * @Description: 删除用户
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public void deleteUser(User user) {
        userMapper.delete(user);

    }

    /**
    * @Description: 根据Uid查找用户
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public User getUserById(User user) {
        User user1 = userMapper.selectByPrimaryKey(user);

     return user1;
    }

   /**
   * @Description: 更新用户信息
   * @Param:
   * @return:
   * @Date: 2019/8/22 0022
   */

    public void updateUserById(User user) {
        userMapper.updateByPrimaryKey(user);

    }

    /**
    * @Description: 统计用户的人数
    * @Param:
    * @return:
    * @Date: 2019/8/26 0026
    */

    public int countUser() {
        User t = new User();
        int count = userMapper.selectCount(t);

        return count;


    }
    /**
    * @Description: 分页查询所有用户
    * @author: chenzhen
    * @Date: 2019/9/21 0021
    */
    public List<User> pageUser(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<User> userList = userMapper.selectAll();

        return PageHelperUtils.getResultList(userList);
    }
}
