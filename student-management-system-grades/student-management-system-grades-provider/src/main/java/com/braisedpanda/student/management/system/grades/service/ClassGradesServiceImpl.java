package com.braisedpanda.student.management.system.grades.service;


import com.braisedpanda.student.management.system.commons.utils.PageHelperUtils;
import com.braisedpanda.student.management.system.grades.mapper.ClassGradesMapper;
import com.braisedpanda.student.management.system.grades.model.po.ClassGrades;
import com.braisedpanda.student.management.system.grades.model.po.ClassGradesCard;
import com.braisedpanda.student.management.system.grades.model.vo.CustomClassGradesVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.apache.dubbo.config.annotation.Service(version="1.0.0")
public class ClassGradesServiceImpl implements ClassGradesService {
    @Autowired
    ClassGradesMapper classGradesMapper;


    ClassGradesCardService classGradesCardService;

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

    /** 
    * @Description: 分页查询班级成绩
    * @author: chenzhen
    * @Date: 2019/9/21 0021 
    */
    public List pageClassGrades(int page,int limit) {
        PageHelper.startPage(page,limit);
        List<ClassGrades> classGradesList = classGradesMapper.selectAll();

        return PageHelperUtils.getResultList(classGradesList);



    }
}
