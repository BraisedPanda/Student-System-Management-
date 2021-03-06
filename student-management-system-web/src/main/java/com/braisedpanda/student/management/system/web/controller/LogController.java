package com.braisedpanda.student.management.system.web.controller;


import com.braisedpanda.student.management.system.commons.utils.JsonUtils;
import com.braisedpanda.student.management.system.commons.utils.ResultType;
import com.braisedpanda.student.management.system.domain.model.OperationLog;
import com.braisedpanda.student.management.system.log.service.LogService;
import com.braisedpanda.student.management.system.web.log.LogAnnotation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: MicroService-of-Student-Management-System
 * @description: 日志及表格Controller
 * @author: chenzhen
 * @create: 2019-09-25 10:48
 **/

@Controller
public class LogController {

    @Reference(version = "1.0.0")
    LogService logService;

    @RequestMapping("tologpage")
    @LogAnnotation
    public ModelAndView toLogPage(){
        return new ModelAndView("log/operation_log");
    }

    @LogAnnotation
    @RequestMapping("operation_log")
    @ResponseBody
    public String pageOperationLog(int page,int limit){
        int count = logService.count();
        List<OperationLog> resultList = logService.pageOperationLog(page,limit);

        String result = JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();

        return result;
    }

    /**
    * @Description: 跳转到到show页面
    * @author: chenzhen
    * @Date: 2019/9/30 0030
    */
    @LogAnnotation
    @RequestMapping("toshow")
    public ModelAndView toShow(){
        return new ModelAndView("menu/show");
    }

}
