package com.braisedpanda.student.management.system.permission.mapper;


import com.braisedpanda.student.management.system.domain.model.RolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolePermissionMapper extends tk.mybatis.mapper.common.Mapper<RolePermission>{

    List<String> getPermission(String uid);
}
