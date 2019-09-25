package com.braisedpanda.student.management.system.web.controller;


import com.braisedpanda.student.management.system.commons.utils.JsonUtils;
import com.braisedpanda.student.management.system.commons.utils.ResultType;
import com.braisedpanda.student.management.system.domain.model.SClass;
import com.braisedpanda.student.management.system.grades.service.GradesService;

import com.braisedpanda.student.management.system.sclass.service.ClassService;
import com.braisedpanda.student.management.system.student.service.NationService;
import com.braisedpanda.student.management.system.student.service.StudentService;
import com.braisedpanda.student.management.system.web.biz.ClassBiz;
import com.braisedpanda.student.management.system.web.log.LogAnnotation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ClassController {
    @Reference(version="1.0.0")
    StudentService studentService;
    @Reference(version="1.0.0")
    NationService nationService;
    @Reference(version="1.0.0")
    GradesService gradesService;
    @Reference(version="1.0.0")
    ClassService classService;

    @Autowired
    ClassBiz classBiz;


    //批量生成学生测试数据
    @ResponseBody
    @RequestMapping("insertClass")
    @LogAnnotation
    public void insertClass2(){

       classBiz.insertClass();


    }


    //查询所有班级
    @RequestMapping("class/all")
    public @ResponseBody
    @LogAnnotation(operateType="查询所有班级")
    String allClass2(int page, int limit){
        int count = classService.countSClass();
        List<SClass> resultList = classService.pageClass(page,limit);

       String  result = JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();

        return result;

    }

    //跳转界面
    @RequestMapping("toclasslist")
    @LogAnnotation
    public String toclasslist(){
        return "class/allclass";
    }


    //根据classid值删除class
    @ResponseBody
    @RequestMapping("class/delete/{classId}")
    @LogAnnotation(operateType="删除班级")
    public void deleteClassById(@PathVariable("classId") String classId){
        SClass sClass = new SClass();
        sClass.setClassId(classId);
        classService.deleteSClassById(sClass);
    }

    //跳转到编辑班级界面
    @RequestMapping("class/toeditclass/{classId}")
    @LogAnnotation
    public ModelAndView toeidtclass2(@PathVariable("classId") String classId){

        ModelAndView modelAndView = new ModelAndView();
        SClass sClass = new SClass();
        sClass.setClassId(classId);
        SClass sclass =  classService.getSClassById(sClass);

        modelAndView.addObject("class",sclass);

        modelAndView.setViewName("class/editClass");

        return modelAndView;

    }

    //编辑班级信息（提交到数据库）
    @RequestMapping("editclass")
    @LogAnnotation(operateType="编辑班级信息")
    public String editClass2(SClass sClass, Model model){

        classService.updateSClassById(sClass);

        model.addAttribute("msg","编辑班级信息成功");

        return "menu/msg";
    }


    /*
    跳转到班级详细成绩的页面
     */
    @RequestMapping("class/todetail")
    @LogAnnotation
    public String class_todetail(String class_cid,Model model){
        model.addAttribute("class_cid",class_cid);
        return "class/class_student_detail";
    }




    //根据班级的classid查询出该班级所有学生的每次考试成绩，并把数据返回给前端

    @ResponseBody
    @RequestMapping("class/detail/{class_cid}")
    @LogAnnotation(operateType="查询班级所有学生的成绩")
    public String classDetail2(@PathVariable("class_cid") String class_cid,int page,int limit,Model model){
        model.addAttribute("class_cid",class_cid);

        String result = classBiz.classDetail(class_cid,page,limit);

        return result;

    }



    //跳转到所有班级成绩
    @RequestMapping("toclassgrades")
    @LogAnnotation(operateType="查询所有班级成绩")
    public String toclassgrades(){
        return "class/classgrades";
    }

}
