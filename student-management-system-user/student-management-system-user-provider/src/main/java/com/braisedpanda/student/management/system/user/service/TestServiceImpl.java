package com.braisedpanda.student.management.system.user.service;


import org.apache.dubbo.config.annotation.Service;

/**
 * @program: MicroService-of-Student-Management-System
 * @description: sad
 * @author: chenzhen
 * @create: 2019-09-20 14:30
 **/
@Service(version = "1.0.0")
public class TestServiceImpl implements TestService{
    public String test() {
        return "666666";
    }
}
