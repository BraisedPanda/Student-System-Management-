package com.braisedpanda.student.management.system.permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: MicroService-of-Student-Management-System
 * @description: permission
 * @author: chenzhen
 * @create: 2019-09-20 16:46
 **/
@EnableDiscoveryClient
@EnableAutoConfiguration
@MapperScan("com.braisedpanda.student.management.system.permission.mapper")
public class PermissionApplication {
    public static void main(String[] args) {
        SpringApplication.run(PermissionApplication.class,args);
    }
}
