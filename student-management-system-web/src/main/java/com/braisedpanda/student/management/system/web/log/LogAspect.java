package com.braisedpanda.student.management.system.web.log;

import com.braisedpanda.student.management.system.commons.utils.IPUtils;
import com.braisedpanda.student.management.system.domain.model.OperationLog;
import com.braisedpanda.student.management.system.domain.model.User;
import com.braisedpanda.student.management.system.log.service.LogService;
import com.netflix.client.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: MicroService-of-Student-Management-System
 * @description: 日志切面
 * @author: chenzhen
 * @create: 2019-09-25 10:44
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Reference(version = "1.0.0")
    LogService logService;

    //统一切点,对com.braisedpanda.student.management.system.web.controller及其子包中所有的类的所有方法切面
    @Pointcut("execution(public * com.braisedpanda.student.management.system.web.controller..*.*(..))")
    public void Pointcut() {
    }

    /**
    * @Description:  环绕通知
     * 1、获取ip地址
     * 2、获取当前登录的用户（如果有的话）
     * 3、获取操作的方法名称
     * 4、获取操作的时间
     * 5、操作结果（成功|失败）
    * @author: chenzhen
    * @Date: 2019/9/25 0025
    */

    @Around("Pointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();
        // 获取方法上面的注解
        LogAnnotation logAnno = method.getAnnotation(LogAnnotation.class);
        String operateType1 = logAnno.operateType();

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        String ip = IPUtils.getIpAddress(request);

        HttpSession session = request.getSession();
        User user =  (User)session.getAttribute("user");

        // 计时并调用目标函数
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataStr = format.format(date);

        OperationLog log = new OperationLog();
        log.setIp(ip);
        log.setOperation(operateType1);
        log.setTime(dataStr);
        if(user != null){
            String username = user.getUsername();
            log.setUsername(username);
        }

        try {
            Object object = pjp.proceed();
            log.setResult("操作成功");
        }catch (Exception e){
            log.setResult("操作失败");
        }
        if(log.getUsername() !=null && log.getOperation()!=null && log.getOperation().length()>0){
            logService.insert(log);
        }
        Object result = pjp.proceed();
        return result;
    }

}
