package com.braisedpanda.student.management.system.student.mapper;


import com.braisedpanda.student.management.system.student.model.po.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudentMapper extends tk.mybatis.mapper.common.Mapper<Student>{

    List<String> selectAllClassId();
}
