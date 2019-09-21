package com.braisedpanda.student.management.system.sclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: MicroService-of-Student-Management-System
 * @description: fgasd
 * @author: chenzhen
 * @create: 2019-09-21 10:18
 **/
@EnableDiscoveryClient
@EnableAutoConfiguration
@MapperScan("com.braisedpanda.student.management.system.sclass.mapper")
public class ClassApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClassApplication.class,args);
    }
}
