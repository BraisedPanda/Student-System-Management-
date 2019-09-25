package com.braisedpanda.student.management.system.log.service;

import com.braisedpanda.student.management.system.commons.utils.PageHelperUtils;
import com.braisedpanda.student.management.system.domain.model.OperationLog;
import com.braisedpanda.student.management.system.log.mapper.LogMapper;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: MicroService-of-Student-Management-System
 * @description:
 * @author: chenzhen
 * @create: 2019-09-25 14:04
 **/
@Service(version = "1.0.0")
public class LogServiceImpl implements LogService{
    @Autowired
    LogMapper logMapper;

    /**
    * @Description: 添加操作日志
    * @author: chenzhen
    * @Date: 2019/9/25 0025
    */
    public void insert(OperationLog operationLog) {
        logMapper.insert(operationLog);
    }

    /**
    * @Description: 查看操作日志
    * @author: chenzhen
    * @Date: 2019/9/25 0025
    */
    public List<OperationLog> pageOperationLog(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<OperationLog> operationLogList = logMapper.selectAll();
        return PageHelperUtils.getResultList(operationLogList);
    }
    /**
    * @Description: 查询所有的operationlog总数
    * @author: chenzhen
    * @Date: 2019/9/25 0025
    */

    public int count() {
        return logMapper.selectCount(new OperationLog());
    }
}
