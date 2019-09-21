package com.braisedpanda.student.management.system.grades.service;


import com.braisedpanda.student.management.system.grades.model.po.StudentGrades;

public interface StudentGradesService {

    //插入学生成绩
    void insertStudentGrades(StudentGrades studentGrades);

    //根据id查询学生成绩
    StudentGrades getStudentGradesByCardId(String stugradesCardId);

}
