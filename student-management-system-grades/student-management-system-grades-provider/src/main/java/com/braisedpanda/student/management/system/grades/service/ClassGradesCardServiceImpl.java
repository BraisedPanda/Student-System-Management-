package com.braisedpanda.student.management.system.grades.service;

import com.braisedpanda.student.management.system.grades.mapper.ClassGradesCardMapper;
import com.braisedpanda.student.management.system.domain.model.ClassGradesCard;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service(version="1.0.0")
public class ClassGradesCardServiceImpl implements ClassGradesCardService {
    @Autowired
    ClassGradesCardMapper classGradesCardMapper;


    /** 
    * @Description: 获取所有的班级成绩卡
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public List<ClassGradesCard> listClassGradesCard() {
        List<ClassGradesCard> list = classGradesCardMapper.selectAll();
        return list;
    }

    /** 
    * @Description: 批量生成学生成绩卡
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public void insertClassGradesCard(ClassGradesCard cgcrad) {
        classGradesCardMapper.insert(cgcrad);
    }
        
    /**
    * @Description:  根据id查找班级成绩卡
    * @Param:
    * @return:
    * @Date: 2019/8/27 0027
    */



    public ClassGradesCard getClassGradesCardByID(String classGradesCardId) {
        ClassGradesCard card = classGradesCardMapper.selectByPrimaryKey(classGradesCardId);
        return card;
    }

}
