package com.braisedpanda.student.management.system.log.service;

import com.braisedpanda.student.management.system.domain.model.OperationLog;

import java.util.List;

public interface LogService {
    void insert(OperationLog operationLog);

    List<OperationLog> pageOperationLog(int page, int limit);

    int count();
}
