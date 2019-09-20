package com.braisedpanda.student.management.system.web.controller;

import com.braisedpanda.student.management.system.user.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: MicroService-of-Student-Management-System
 * @description: dsa
 * @author: chenzhen
 * @create: 2019-09-20 14:32
 **/
@Controller
public class TestController {

    @Reference(version = "1.0.0")
    TestService testService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("12345676");
       return testService.test();
    }

}
