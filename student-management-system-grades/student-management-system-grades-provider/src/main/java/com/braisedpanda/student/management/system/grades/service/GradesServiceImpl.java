package com.braisedpanda.student.management.system.grades.service;


import com.braisedpanda.student.management.system.grades.mapper.GradesMapper;
import com.braisedpanda.student.management.system.grades.model.po.StudentGradesCard;
import com.braisedpanda.student.management.system.grades.model.vo.StudentGradesCustomVO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service(version="1.0.0")
public class GradesServiceImpl implements GradesService {
    @Autowired
    GradesMapper gradesMapper;



    public List<StudentGradesCustomVO> getStuGradesBystuId(String stuId) {
        List<StudentGradesCustomVO> sgcList = gradesMapper.getStuGradesBystuId(stuId);

        return sgcList;
    }

    //获取部分的学生成绩卡信息(只获取考试时间和考试描述)

    public List<StudentGradesCard> getSGCard() {
         List<StudentGradesCard> list =  gradesMapper.getSGCard();
         return list;
    }










}
