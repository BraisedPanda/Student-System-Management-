package com.braisedpanda.student.management.system.sclass.service;



import com.braisedpanda.student.management.system.sclass.model.SClass;

import java.util.List;


public interface ClassService {

    //添加班级
    void insertClass(SClass sclass);

    //查找出所有的班级
    List<SClass> listSClass();


    //根据classid值删除class
    void deleteSClassById(SClass sClass);

    //根据classid查找对应的class
    SClass getSClassById(SClass sClass);

    // 更新班级信息
    void updateSClassById(SClass sClass);

    //获取所有的班级id
    List<String> listClassId();
    //统计出班级的数目
    int countSClass();
}
