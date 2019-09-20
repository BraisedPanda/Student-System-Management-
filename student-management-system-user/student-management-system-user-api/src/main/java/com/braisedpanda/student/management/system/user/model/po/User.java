package com.braisedpanda.student.management.system.user.model.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name="user")
public class User implements Serializable{
    private static final long serialVersionUID = -700577685605456958L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    @Column(name="uid")
    private Integer uid;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="birthday")
    private String birthday;
    @Column(name="gender")
    private String gender;
    @Column(name="activeCode")
    private String activeCode;
    @Column(name="images")
    private String images;



}
