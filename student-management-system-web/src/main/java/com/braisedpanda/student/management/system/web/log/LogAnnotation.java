package com.braisedpanda.student.management.system.web.log;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @program: MicroService-of-Student-Management-System
 * @description: 自定义log注解
 * @author: chenzhen
 * @create: 2019-09-25 11:13
 **/
@Target(ElementType.METHOD) // 方法注解
@Retention(RetentionPolicy.RUNTIME) // 运行时可见
public @interface LogAnnotation {
    String operateType() default "";// 记录日志的操作类型

}