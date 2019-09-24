package com.braisedpanda.student.management.system.permission.service;


import com.braisedpanda.student.management.system.domain.model.Permission;
import com.braisedpanda.student.management.system.domain.model.RolePermission;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version="1.0.0")
public interface RolePermissionService {

    //添加对应的角色-权限表

    void insertRolePermission(RolePermission rp);

    //查找所有的rolePermission内容

    List<RolePermission> listRolePermission();
    //根据rPId删除角色所拥有的权限

    void deleteRolePermissionById(RolePermission rolePermission);

    //根据roleId查找rolePermission对象
    List<RolePermission>  listRolePermissionByRoleId(String roleId);

    //根据roleId删除rolePermission表中所有的权限
    void deleteRolePermissionByroleId(String roleId);

    //通过uid获取permission字段
    List<String> getPermission(String uid);
    //统计rolePermission表中所有的记录数
    int countRolePermission();
    //分页查询rolePermission
    List<Permission> pagePermission(int page, int limit);
}
