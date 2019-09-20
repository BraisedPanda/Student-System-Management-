package com.braisedpanda.student.management.system.permission.service;

import com.braisedpanda.student.management.system.permission.model.po.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@org.apache.dubbo.config.annotation.Service(version="1.0.0")
public interface RoleService {
    //添加角色
    void insertRole(Role role);

    //查找所有的角色
    List<Role> selectAllRole();

    //根据roleId查询role表中对应的role
    Role getRoleById(Role role);

    //在role表中更新role的相关权限、名称等信息
    void updateRole(Role role);

    //根据roleId删除role表中的role
    void deleteRoleByroleId(Role role);

    //统计出role表中所有的数目
    int countRole();
}
