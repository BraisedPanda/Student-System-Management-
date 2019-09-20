package com.braisedpanda.student.management.system.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: MicroService-of-Student-Management-System
 * @description: gfsad
 * @author: chenzhen
 * @create: 2019-09-20 11:53
 **/
@EnableDiscoveryClient
@EnableAutoConfiguration
@MapperScan("com.braisedpanda.student.management.system.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
