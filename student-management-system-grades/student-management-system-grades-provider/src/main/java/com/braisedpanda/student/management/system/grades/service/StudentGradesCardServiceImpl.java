package com.braisedpanda.student.management.system.grades.service;


import com.braisedpanda.student.management.system.grades.mapper.StudentGradesCardMapper;
import com.braisedpanda.student.management.system.domain.model.StudentGradesCard;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@org.apache.dubbo.config.annotation.Service(version="1.0.0")
public class StudentGradesCardServiceImpl implements StudentGradesCardService {
    @Autowired
    StudentGradesCardMapper studentGradesCardMapper;

    /** 
    * @Description: 添加学生成绩卡 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public void insertStudentGradesCard(StudentGradesCard card) {
        studentGradesCardMapper.insert(card);
    }
    
    /** 
    * @Description:  根据stuId查找所有的学生成绩卡
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public List<StudentGradesCard> listStudentGradesCardByStuId(String stuId) {
        Example example = new Example(StudentGradesCard.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("stuId",stuId);
        List<StudentGradesCard> cardList = studentGradesCardMapper.selectByExample(example);

        return cardList;

    }

    /**
    * @Description:根据描述和cardid查找学生成绩卡
    * @Param:
    * @return:
    * @Date: 2019/8/27 0027
    */

    public StudentGradesCard getGradesCardById_and_DesCribe(String stuId, String timeDescribe) {

        Example example = new Example(StudentGradesCard.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("stuId",stuId);
        criteria.andEqualTo("timeDescribe",timeDescribe);
        StudentGradesCard card = studentGradesCardMapper.selectOneByExample(example);

        return card;
    }



}
