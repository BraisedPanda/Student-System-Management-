package com.braisedpanda.student.management.system.permission.service;


import com.braisedpanda.student.management.system.permission.model.po.Permission;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version="1.0.0")
public interface PermissionService {


    //获取所有的权限
    List<Permission> selecAllPermission();

    //根据权限的id值，查询对应的权限
    Permission getPermissionById(String permissionId);

    //分页查询permission
    List<Permission> pagePermission(int page, int limit);
    //查询权限的总数
    int countPermission();
}
