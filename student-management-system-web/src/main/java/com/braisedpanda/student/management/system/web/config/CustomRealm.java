package com.braisedpanda.student.management.system.web.config;



import com.braisedpanda.student.management.system.permission.model.po.UserRole;
import com.braisedpanda.student.management.system.permission.service.PermissionService;
import com.braisedpanda.student.management.system.permission.service.RolePermissionService;
import com.braisedpanda.student.management.system.permission.service.UserRoleService;
import com.braisedpanda.student.management.system.user.model.po.User;
import com.braisedpanda.student.management.system.user.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Reference(version = "1.0.0")
    UserService userService;
    @Reference(version = "1.0.0")
    UserRoleService userRoleService;
    @Reference(version = "1.0.0")
    PermissionService permissionService;
    @Reference(version = "1.0.0")
    RolePermissionService rolePermissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("========开始权限验证========");

        User user = (User)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //查询登录用户所拥有的角色，并添加角色
        int uid = user.getUid();
        List<UserRole> roleList = userRoleService.getUserRoleByUid(uid);

        for (UserRole role:
             roleList) {
           info.addRole(role.getRole());


           String roleId= role.getRoleId();
            List<String> permissionList= rolePermissionService.getPermission(roleId);
            //查询登录用户所拥有的权限，并添加权限
            for (String  permission:
                    permissionList) {
                info.addStringPermission(permission);
            }

        }

        return info;
    }

    //重写验证身份的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("========开始身份验证========");
        String username = (String) authenticationToken.getPrincipal();

        String password = new String((char[]) authenticationToken.getCredentials());


        User user = userService.selectUserByUsernameAndPasword(username,password);

        if (user == null) {
            throw new AccountException("用户名或密码错误");
        }

        return new SimpleAuthenticationInfo(user, password, getName());

    }



}