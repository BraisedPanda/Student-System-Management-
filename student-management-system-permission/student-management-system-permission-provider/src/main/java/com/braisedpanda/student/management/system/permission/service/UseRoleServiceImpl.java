package com.braisedpanda.student.management.system.permission.service;


import com.braisedpanda.student.management.system.permission.mapper.UserRoleMapper;
import com.braisedpanda.student.management.system.domain.model.UserRole;
import com.braisedpanda.student.management.system.domain.model.User;

import com.braisedpanda.student.management.system.permission.model.vo.UserVO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0.0")
public class UseRoleServiceImpl implements UserRoleService{

    @Autowired
    UserRoleMapper userRoleMapper;
    //根据用户名查找权限

    /**
    * @Description: 根据传入的uid查找该用户的所有角色
    * @Param:  uid
    * @return:  List<UserRole>
    * @Date: 2019/8/22 0022
    */

    public List<UserRole> getUserRoleByUid(int uid) {
        Example example = new Example(UserRole.class);
        Example.Criteria  criteria = example.createCriteria();
        criteria.andEqualTo("uid",uid);
        List<UserRole> roleList = userRoleMapper.selectByExample(example);
        return roleList;
    }

    
    /** 
    * @Description: 新增userRole 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public void insertUserRole(UserRole userRole) {
        userRoleMapper.insert(userRole);

    }


    /**
     * @Description: 在表userRole中删除所有uid的角色
     * @Param:
     * @return:
     * @Date: 2019/8/22 0022
     */

    public void deleteRoleByUid(int uid) {

        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uid",uid);
        userRoleMapper.deleteByExample(example);
    }
    /** 
    * @Description: 根据传入的user集合，设置他们的角色权限信息
    * @author: chenzhen
    * @Date: 2019/9/23 0023 
    */ 
    public List<UserVO> pageUser(List<User> userList) {
        List<UserVO> userVOList = new ArrayList<UserVO>();

        for (User user:
                userList) {
            UserVO userVO = new UserVO();
            int uid = user.getUid();
            Example example = new Example(UserRole.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("uid",uid);
            List<UserRole> userRoleList = userRoleMapper.selectByExample(example);
            userVO.setUserRoleList(userRoleList);
            userVO.setUid(user.getUid());
            userVO.setUsername(user.getUsername());
            userVO.setPassword(user.getPassword());
            userVO.setBirthday(user.getBirthday());
            userVO.setEmail(user.getEmail());
            userVO.setGender(user.getGender());
            userVO.setImages(user.getImages());
            userVOList.add(userVO);

        }
            return userVOList;
    }
}
