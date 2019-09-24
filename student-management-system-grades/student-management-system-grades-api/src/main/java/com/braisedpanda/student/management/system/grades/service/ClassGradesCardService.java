package com.braisedpanda.student.management.system.grades.service;


import com.braisedpanda.student.management.system.domain.model.ClassGradesCard;

import java.util.List;


public interface ClassGradesCardService {

    //获取所有的班级成绩卡片
    List<ClassGradesCard> listClassGradesCard();

    //批量生成学生成绩卡
    void insertClassGradesCard(ClassGradesCard cgcrad);

    //根据id查找班级成绩卡
    ClassGradesCard getClassGradesCardByID(String classGradesCardId);
}
