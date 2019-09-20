package com.braisedpanda.student.management.system.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.openfeign.FeignAutoConfiguration;

/**
 * @program: MicroService-of-Student-Management-System
 * @description: web端
 * @author: chenzhen
 * @create: 2019-09-20 14:10
 **/
@SpringBootApplication(exclude = {FeignAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
