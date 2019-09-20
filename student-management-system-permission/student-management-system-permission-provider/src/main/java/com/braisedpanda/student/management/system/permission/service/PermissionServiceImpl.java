package com.braisedpanda.student.management.system.permission.service;


import com.braisedpanda.student.management.system.permission.mapper.PermissionMapper;
import com.braisedpanda.student.management.system.permission.model.po.Permission;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service(version = "1.0.0")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;


    /** 
    * @Description: 查询所有的权限信息
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public List<Permission> selecAllPermission() {
//        List<Permission> permissionList = permissionMapper.getAllPermission();
        List<Permission> permissionList = permissionMapper.selectAll();
        return permissionList;
    }

    /**
    * @Description: 根据权限id查出对应的权限
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public Permission getPermissionById(String per) {
//       Permission permission =  permissionMapper.getPermissionById(s1);
        Permission permission =  permissionMapper.selectByPrimaryKey(per);
       return permission;

    }




}
