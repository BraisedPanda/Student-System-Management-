package com.braisedpanda.student.management.system.student.service;


import com.braisedpanda.student.management.system.student.mapper.StudentMapper;
import com.braisedpanda.student.management.system.student.model.po.Student;
import com.braisedpanda.student.management.system.commons.utils.PageHelperUtils;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    /** 
    * @Description: 添加学生
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public void insertStudent(Student student) {

        studentMapper.insert(student);
    }

    /**
    * @Description: 查找所有学生
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public List<Student> selectAllStudent() {

        List<Student> studentList = studentMapper.selectAll();
        return studentList;
    }

    /**
    * @Description: 根据学生id删除学生
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public void deleteStudentById(Student student) {

        studentMapper.deleteByPrimaryKey(student);
    }

    /**
    * @Description: 根据学校id查找学生
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public Student selectStudentById(Student student) {
        Student student2 = studentMapper.selectByPrimaryKey(student);

      return student2;
    }

    /**
    * @Description: 更新学生信息
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public void updateStudent(Student student) {
        studentMapper.updateByPrimaryKey(student);

    }
    /**
    * @Description: 查询所有学生的班级
    * @Param:
    * @return: classId值
    * @Date: 2019/8/22 0022
    */

    public List<String> selectAllClassId() {
       List<String> classIdlist = studentMapper.selectAllClassId();

        return classIdlist;

    }

    /**
    * @Description: 根据班级id查找学生的总数
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public int countStudentByCid(String classid) {

        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("classId",classid);
        int count = studentMapper.selectCountByExample(example);
       return count;
    }


    /** 
    * @Description: 根据班级的classid查找出该班的所有学生
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public List<Student> getStudentByClassId(String classId) {

        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("classId",classId);
        List<Student> list = studentMapper.selectByExample(example);
        return list;
    }
    /**
    * @Description: 查询所有的学生
    * @Param:
    * @return:
    * @Date: 2019/8/26 0026
    */

    public int countStudent() {
        Student student = new Student();
        int count = studentMapper.selectCount(student);
        return count;
    }
    /** 
    * @Description: 分页查询学生
    * @author: chenzhen
    * @Date: 2019/9/21 0021 
    */ 
    public List<Student> pageStudent(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Student> studentList = studentMapper.selectAll();

        return PageHelperUtils.getResultList(studentList);
    }
}
