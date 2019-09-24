package com.braisedpanda.student.management.system.permission.model.vo;



import com.braisedpanda.student.management.system.domain.model.UserRole;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * @program: MicroService-of-Student-Management-System
 * @description: user页面返回类
 * @author: chenzhen
 * @create: 2019-09-23 10:16
 **/
@Data
public class UserVO implements Serializable{

    private static final long serialVersionUID = 5572539762217344703L;
    private Integer uid;

    private String username;

    private String password;

    private String email;

    private String birthday;

    private String gender;

    private String activeCode;

    private String images;

    private List<UserRole> userRoleList;
}
