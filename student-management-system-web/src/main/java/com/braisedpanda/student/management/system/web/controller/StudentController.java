package com.braisedpanda.student.management.system.web.controller;

import com.braisedpanda.student.management.system.domain.model.SClass;
import com.braisedpanda.student.management.system.grades.service.GradesService;
import com.braisedpanda.student.management.system.permission.service.PermissionService;

import com.braisedpanda.student.management.system.sclass.service.ClassService;
import com.braisedpanda.student.management.system.domain.model.Nation;
import com.braisedpanda.student.management.system.domain.model.Student;
import com.braisedpanda.student.management.system.student.service.NationService;
import com.braisedpanda.student.management.system.student.service.StudentService;
import com.braisedpanda.student.management.system.user.service.UserService;
import com.braisedpanda.student.management.system.web.biz.StudentBiz;
import com.braisedpanda.student.management.system.commons.utils.JsonUtils;
import com.braisedpanda.student.management.system.commons.utils.ResultType;
import com.braisedpanda.student.management.system.web.log.LogAnnotation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class StudentController {
    @Reference(version = "1.0.0")
    StudentService studentService;
    @Reference(version = "1.0.0")
    NationService nationService;
    @Reference(version = "1.0.0")
    GradesService gradesService;
    @Reference(version = "1.0.0")
    UserService userService;
    @Reference(version = "1.0.0")
    PermissionService permissionService;
    @Reference(version = "1.0.0")
    ClassService classService;
    @Autowired
    StudentBiz studentBiz;


    //批量生成学生测试数据
    @RequestMapping("addStudent")
    public void addStudent2(){

         studentBiz.addStudent();

    }


    //查询所有学生
    @RequestMapping("student/all")
    @LogAnnotation(operateType="查询所有学生")
    public @ResponseBody
    String allStudent2(int page, int limit){

            int count = studentService.countStudent();
           List<Student> resultList =  studentService.pageStudent(page,limit);
        String result =  JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();
        return result;

    }

    //删除学生信息
    @RequestMapping("student/delete/{stuId}")
    @LogAnnotation(operateType="删除学生")
    public String delete(@PathVariable("stuId")String stuId){
        Student stu = new Student();
        stu.setStuId(stuId);
        studentService.deleteStudentById(stu);
        return "user/blank";
    }

    //查询学生的学习成绩卡
    @LogAnnotation(operateType="查询所有学生成绩")
    @RequestMapping("student/findcard")
    public void findCard2(){

         studentBiz.findCard();


    }

    //查询学生成绩
    @LogAnnotation(operateType="查询学生成绩")
    @RequestMapping("student/grades/{stuId}")
    public void findStudentGrades2(@PathVariable("stuId") String stuId){

       studentBiz.findStudentGrades(stuId);


    }

    //编辑学生信息
    @LogAnnotation(operateType="编辑学生信息")
    @RequestMapping("/editstudent")
    public String editstudent(Student student){
        studentService.updateStudent(student);
        return "student/allstudent";
    }


    //根据stuId查找用户信息，并返回到界面
    @LogAnnotation(operateType="跳转到编辑学生页面")
    @RequestMapping("student/toeditstudent/{stuId}")
    public ModelAndView toeditstudent2(@PathVariable("stuId") String stuId){
        ModelAndView modelAndView = new ModelAndView();
        Student stu = new Student();
        stu.setStuId(stuId);
        Student student = studentService.selectStudentById(stu);

        modelAndView.addObject("student",student);

        modelAndView.setViewName("student/editstudent");

        return modelAndView;
    }

    //跳转到添加学生界面
    @LogAnnotation(operateType="跳转到添加学生")
    @RequestMapping("toaddstudent")
    public String tostudent2(Model model){

        List<Nation> nationList = nationService.listNation();

        model.addAttribute("nationlist",nationList);

        List<SClass> classList = classService.listSClass();

        model.addAttribute("classlist",classList);

        return "student/addstudent";
    }

    //添加学生信息
    @LogAnnotation(operateType="添加学生信息")
    @RequestMapping("student/addstudent")
    public String addstudent2(Student student){

        studentBiz.addstudent(student);

        return "menu/msg";


    }


    //上传测试代码
    @LogAnnotation
    @RequestMapping("uploadtest")
    public String upload(){
        return "user/upload";
    }


    //显示学生列表
    @LogAnnotation(operateType="查看所有学生")
    @RequestMapping("tostudentlist")
    public String tostudentlist(){
        return "student/allstudent";
    }


}
