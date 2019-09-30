package com.braisedpanda.student.management.system.web.controller;


import com.braisedpanda.student.management.system.web.biz.ChartBiz;
import com.braisedpanda.student.management.system.web.log.LogAnnotation;
import com.braisedpanda.student.management.system.web.model.Chart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @program: MicroService-of-Student-Management-System
 * @description: chartController
 * @author: chenzhen
 * @create: 2019-09-30 11:44
 **/
@RestController
public class ChartController {

    @Autowired
    ChartBiz chartBiz;

    @LogAnnotation
    @PostMapping("classCountChart")
    public  List<Chart> classCountChart(){
        List<Chart> resultList = chartBiz.getChart();

        return resultList;

    }
}
