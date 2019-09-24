package com.braisedpanda.student.management.system.permission.service;


import com.braisedpanda.student.management.system.commons.utils.PageHelperUtils;
import com.braisedpanda.student.management.system.permission.mapper.PermissionMapper;
import com.braisedpanda.student.management.system.domain.model.Permission;
import com.github.pagehelper.PageHelper;
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

    /**
    * @Description: 分页查询permission表
    * @author: chenzhen
    * @Date: 2019/9/21 0021
    */
    public List<Permission> pagePermission(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Permission> permissionList = permissionMapper.selectAll();
        return PageHelperUtils.getResultList(permissionList);
    }

    public int countPermission() {
        Permission permission =new Permission();
        return permissionMapper.selectCount(permission);
    }


}
