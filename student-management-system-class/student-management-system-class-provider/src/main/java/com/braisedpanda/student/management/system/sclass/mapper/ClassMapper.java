package com.braisedpanda.student.management.system.sclass.mapper;


import com.braisedpanda.student.management.system.domain.model.SClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper extends tk.mybatis.mapper.common.Mapper<SClass>{


    /**
    * @Description: 获取所有班级的id
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    List<String> listClassId();
}
