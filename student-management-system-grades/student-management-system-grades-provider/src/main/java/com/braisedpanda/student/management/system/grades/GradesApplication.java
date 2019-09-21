package com.braisedpanda.student.management.system.grades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: MicroService-of-Student-Management-System
 * @description: fasd
 * @author: chenzhen
 * @create: 2019-09-21 10:30
 **/
@EnableAutoConfiguration
@EnableDiscoveryClient
@MapperScan("com.braisedpanda.student.management.system.grades.mapper")
public class GradesApplication {
    public static void main(String[] args) {
        SpringApplication.run(GradesApplication.class,args);
    }
}
