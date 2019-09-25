package com.braisedpanda.student.management.system.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: MicroService-of-Student-Management-System
 * @description:
 * @author: chenzhen
 * @create: 2019-09-25 14:25
 **/
@EnableDiscoveryClient
@EnableAutoConfiguration
public class LogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class,args);
    }
}
