package com.braisedpanda.student.management.system.grades.service;



import com.braisedpanda.student.management.system.domain.model.ClassGrades;

import java.util.List;

public interface ClassGradesService {

    //统计出所有班级成绩的数目
    int countClassGrades();
    //统计出所有班级成绩
    List<ClassGrades> listClassGrades();

    //插入班级成绩
    void insertClassGrades(ClassGrades ClassGrades);
    //分页查询班级成绩
    List<ClassGrades> pageClassGrades(int page,int limit);
}
