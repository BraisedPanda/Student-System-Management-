package com.braisedpanda.student.management.system.web.controller;

import com.braisedpanda.student.management.system.grades.service.ClassGradesService;
import com.braisedpanda.student.management.system.grades.service.GradesService;
import com.braisedpanda.student.management.system.sclass.service.ClassService;
import com.braisedpanda.student.management.system.student.service.NationService;
import com.braisedpanda.student.management.system.student.service.StudentService;
import com.braisedpanda.student.management.system.domain.model.User;
import com.braisedpanda.student.management.system.web.biz.ClassBiz;
import com.braisedpanda.student.management.system.web.biz.GradesBiz;
import com.braisedpanda.student.management.system.web.log.LogAnnotation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class GradesController {
    @Reference(version = "1.0.0")
    StudentService studentService;
    @Reference(version = "1.0.0")
    NationService nationService;
    @Reference(version = "1.0.0")
    GradesService gradesService;
    @Reference(version = "1.0.0")
    ClassService classService;
    @Reference(version = "1.0.0")
    ClassGradesService classGradesService;
    @Autowired
    GradesBiz gradesBiz;
    @Autowired
    ClassBiz classBiz;


    //批量生成学生成绩卡数据
    @RequestMapping("insertGradesCard")
    @LogAnnotation
    public String insertGradesCard1(){

        gradesBiz.insertGradesCard();

        return "user/blank";

    }

    //批量生成学生成绩
    @RequestMapping("insertGrades")
    @LogAnnotation
    public void insertGrades(){

       gradesBiz.insertGrades();


    }
    //查询学生成绩
    @ResponseBody
    @RequestMapping("grades/sudent/{stuId}")
    @LogAnnotation(operateType="查询学生成绩")
    public String getStudentGrades2(@PathVariable("stuId") String stuId,int page,int limit){

        String result = gradesBiz.getStudentGrades(stuId,page,limit);

        return result;

    }

    //跳转到我的成绩
    @RequestMapping("tostudentgrades")
    @LogAnnotation(operateType="查看我的成绩")
    public String tostudentgrades2(Model model,HttpSession session){

        User user = (User)session.getAttribute("user");

        String stuId = user.getActiveCode();

        model.addAttribute("stuId",stuId);

        return "student/studentgrades";

    }

    //批量生成班级成绩卡
    @ResponseBody
    @RequestMapping("autoinsertClass_gardes_card")
    @LogAnnotation
    public void autoinsertClass_gardes_card2(){
        gradesBiz.autoinsertClass_gardes_card();

    }

    //批量生成班级成绩统计
    @ResponseBody
    @RequestMapping("insertClassGrades")
    @LogAnnotation
    public void insertClassGrades2(){

         gradesBiz.insertClassGrades();



    }

    //查询班级分数
    @ResponseBody
    @RequestMapping("classgrades")
    @LogAnnotation(operateType="查询班级成绩")
    public String classgrades2(int page,int limit){
        int count = classGradesService.countClassGrades();
        List classGradesList = classGradesService.pageClassGrades(page,limit);
        String result = gradesBiz.setClassGrades(classGradesList,page,limit,count);
        return result;

    }

}
