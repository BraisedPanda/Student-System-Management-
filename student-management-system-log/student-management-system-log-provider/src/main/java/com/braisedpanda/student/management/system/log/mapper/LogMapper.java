package com.braisedpanda.student.management.system.log.mapper;

import com.braisedpanda.student.management.system.domain.model.OperationLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper extends tk.mybatis.mapper.common.Mapper<OperationLog> {
}
