package com.braisedpanda.student.management.system.grades.service;


import com.braisedpanda.student.management.system.grades.mapper.ClassGradesMapper;
import com.braisedpanda.student.management.system.grades.model.po.ClassGrades;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.apache.dubbo.config.annotation.Service(version="1.0.0")
public class ClassGradesServiceImpl implements ClassGradesService {
    @Autowired
    ClassGradesMapper classGradesMapper;

    /**
    * @Description: 统计出所有班级成绩的数目
    * @Param:
    * @return:
    * @Date: 2019/8/26 0026
    */

    public int countClassGrades() {
        ClassGrades cg = new ClassGrades();
        int count = classGradesMapper.selectCount(cg);
        return count;
    }
    
    /** 
    * @Description: 查找所有班级的成绩
    * @Param:  
    * @return: 
    * @Date: 2019/8/26 0026 
    */ 

    public List<ClassGrades> listClassGrades() {
        List<ClassGrades> list = classGradesMapper.selectAll();
        return list;
    }

    /**
    * @Description: 插入班级成绩
    * @Param:
    * @return:
    * @Date: 2019/8/27 0027
    */

    public void insertClassGrades(ClassGrades ClassGrades) {
        classGradesMapper.insert(ClassGrades);
    }




}
