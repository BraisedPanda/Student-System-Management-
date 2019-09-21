package com.braisedpanda.student.management.system.student.service;

import com.braisedpanda.student.management.system.student.model.po.Student;

import java.util.List;


public interface StudentService {

    //添加学生
    void insertStudent(Student student);

    //得到所有的学生
    List<Student> selectAllStudent();

    //删除学生信息
    void deleteStudentById(Student student);

    //根据id查找学生信息
    Student selectStudentById(Student student);

    //更新学生信息
    void updateStudent(Student student);

    //查询所有班级的Id
    List<String> selectAllClassId();


    int countStudentByCid(String classid);

    //根据班级id值获取所有的学生
    List<Student> getStudentByClassId(String classId);
    //查询所有的学生
    int countStudent();

    //分页查询学生
    List<Student> pageStudent(int page,int limit);


}
