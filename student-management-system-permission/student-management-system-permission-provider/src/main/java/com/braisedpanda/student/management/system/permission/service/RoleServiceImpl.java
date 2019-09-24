package com.braisedpanda.student.management.system.permission.service;

import com.braisedpanda.student.management.system.commons.utils.PageHelperUtils;
import com.braisedpanda.student.management.system.permission.mapper.RoleMapper;
import com.braisedpanda.student.management.system.domain.model.Role;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;


    /**
    * @Description: 添加角色信息
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public void insertRole(Role role) {
          roleMapper.insert(role);

    }

    /**
    * @Description:  查找所有的角色
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public List<Role> selectAllRole() {

        List<Role> roleList = roleMapper.selectAll();
        return  roleList;
    }
    

    
    /** 
    * @Description: 根据roleId在role中查询相应的role 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public Role getRoleById(Role rol) {

        Role role = roleMapper.selectByPrimaryKey(rol);
        return role;
    }



    /**
    * @Description: 在role表中更新role的相关权限、名称等信息
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public void updateRole(Role role) {

        roleMapper.updateByPrimaryKey(role);
    }

    /**
    * @Description:  根据roleId删除role表中的role
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public void deleteRoleByroleId(Role role) {

        roleMapper.deleteByPrimaryKey(role);
    }
    
    /** 
    * @Description: 统计role表中所有的数目
    * @Param:  
    * @return: 
    * @Date: 2019/8/26 0026 
    */

    public int countRole() {
        Role role = new Role();
        int count = roleMapper.selectCount(role);
        return count;
    }
    /**
    * @Description: 分页查询role表
    * @author: chenzhen
    * @Date: 2019/9/21 0021
    */
    public List<Role> pageRole(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Role> roleList = roleMapper.selectAll();
        return PageHelperUtils.getResultList(roleList);
    }
}
