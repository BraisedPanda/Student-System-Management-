package com.braisedpanda.student.management.system.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: MicroService-of-Student-Management-System
 * @description: sdf
 * @author: chenzhen
 * @create: 2019-09-21 10:01
 **/
@EnableAutoConfiguration
@EnableDiscoveryClient
@MapperScan("com.braisedpanda.student.management.system.student.mapper")
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class,args);
    }
}
