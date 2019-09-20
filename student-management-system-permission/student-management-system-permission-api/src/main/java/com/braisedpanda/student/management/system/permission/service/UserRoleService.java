package com.braisedpanda.student.management.system.permission.service;



import com.braisedpanda.student.management.system.permission.model.po.UserRole;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version="1.0.0")
public interface UserRoleService {
    //根据uid查找所有的UserRole
    List<UserRole> getUserRoleByUid(int uid);


    //新增userRole信息
    void  insertUserRole(UserRole userRole);


    //删除userRole表中所有uid用户
    void deleteRoleByUid(int uid);
}
