package com.braisedpanda.student.management.system.permission.service;



import com.braisedpanda.student.management.system.commons.utils.PageHelperUtils;
import com.braisedpanda.student.management.system.permission.mapper.RolePermissionMapper;
import com.braisedpanda.student.management.system.domain.model.Permission;
import com.braisedpanda.student.management.system.domain.model.RolePermission;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    /** 
    * @Description: 添加对应的角色-权限表
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public void insertRolePermission(RolePermission rp) {
        rolePermissionMapper.insert(rp);
    }

    /**
    * @Description: 查找所有的rolePermission内容
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public List<RolePermission> listRolePermission() {

        List<RolePermission> rolePermissionList = rolePermissionMapper.selectAll();
        return rolePermissionList;
    }

    /**
    * @Description: 根据rPId删除角色所拥有的权限
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public void deleteRolePermissionById(RolePermission rolePermission) {

        rolePermissionMapper.deleteByPrimaryKey(rolePermission);
    }


    /**
    * @Description: 根据roleId查找rolePermission对象
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public List<RolePermission>  listRolePermissionByRoleId(String roleId) {
//        List<RolePermission> rolePermissionlist  = permissionMapper.getRolePermissionById(rPId);
        Example example = new Example(RolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId",roleId);
        List<RolePermission> rolePermissionlist = rolePermissionMapper.selectByExample(example);
        return rolePermissionlist;
    }

    /**
    * @Description: 根据roleId删除rolePermission表中所有的权限
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public void deleteRolePermissionByroleId(String roleId) {
//        permissionMapper.deleteRolePermissionByroleId(roleId);
        Example example = new Example(RolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId",roleId);
        rolePermissionMapper.deleteByExample(example);

    }


    /**
     * @Description: 通过uid获取该用户所有的权限
     * @Param:
     * @return:
     * @Date: 2019/8/22 0022
     */

    public List<String> getPermission(String uid) {
        List<String> permissionlist = rolePermissionMapper.getPermission(uid);
        return permissionlist;
    }

    /**
    * @Description: 统计出RolePermission表中所有的记录数
    * @Param:
    * @return:
    * @Date: 2019/8/26 0026
    */

    public int countRolePermission() {
        RolePermission rp = new RolePermission();
        int count = rolePermissionMapper.selectCount(rp);
        return count;
    }
    /**
    * @Description: 分页查询RolePermission
    * @author: chenzhen
    * @Date: 2019/9/21 0021
    */
    public List<Permission> pagePermission(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<RolePermission> rolePermissionList = rolePermissionMapper.selectAll();
        return PageHelperUtils.getResultList(rolePermissionList);
    }
}
