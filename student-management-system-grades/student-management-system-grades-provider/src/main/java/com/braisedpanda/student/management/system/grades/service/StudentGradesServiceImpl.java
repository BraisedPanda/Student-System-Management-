package com.braisedpanda.student.management.system.grades.service;


import com.braisedpanda.student.management.system.grades.mapper.StudentGradesMapper;
import com.braisedpanda.student.management.system.grades.model.po.StudentGrades;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

@org.apache.dubbo.config.annotation.Service(version="1.0.0")
public class StudentGradesServiceImpl implements StudentGradesService {
    @Autowired
    StudentGradesMapper studentGradesMapper;
    
    /** 
    * @Description: 添加学生成绩
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public void insertStudentGrades(StudentGrades studentGrades) {
        studentGradesMapper.insert(studentGrades);
    }
    /** 
    * @Description: 根据id获取学生信息
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public StudentGrades getStudentGradesByCardId(String stuGradesCardId) {
        Example example = new Example(StudentGrades.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("stugradesCardId",stuGradesCardId);
        StudentGrades studentGrades = studentGradesMapper.selectOneByExample(example);
        return studentGrades;
    }
    
}   
