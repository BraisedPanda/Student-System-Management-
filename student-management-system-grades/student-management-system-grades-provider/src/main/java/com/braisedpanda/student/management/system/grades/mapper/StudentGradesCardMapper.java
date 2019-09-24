package com.braisedpanda.student.management.system.grades.mapper;


import com.braisedpanda.student.management.system.domain.model.StudentGradesCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentGradesCardMapper extends tk.mybatis.mapper.common.Mapper<StudentGradesCard>{


    StudentGradesCard getGradesCardById_and_DesCribe(@Param("stuId") String stuId, @Param("testDescribe") String timeDescribe);

}
