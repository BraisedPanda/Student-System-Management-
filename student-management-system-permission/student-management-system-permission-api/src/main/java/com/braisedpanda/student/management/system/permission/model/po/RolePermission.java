package com.braisedpanda.student.management.system.permission.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="rolepermission")
public class RolePermission implements Serializable{
    private static final long serialVersionUID = 2853616024599406413L;
    @Id
    @Column(name="rPId")
    private String rPId;
    @Column(name="permissionId")
    private String permissionId;
    @Column(name="permission")
    private String permission;
    @Column(name="permissionDescribe")
    private String permissionDescribe;
    @Column(name="roleId")
    private String roleId;
    @Column(name="role")
    private String role;
    @Column(name="roleDescribe")
    private String roleDescribe;


}
