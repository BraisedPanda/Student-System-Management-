package com.braisedpanda.student.management.system.web.biz;


import com.braisedpanda.student.management.system.domain.model.SClass;
import com.braisedpanda.student.management.system.sclass.service.ClassService;
import com.braisedpanda.student.management.system.web.model.Chart;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MicroService-of-Student-Management-System
 * @description:
 * @author: chenzhen
 * @create: 2019-09-30 15:11
 **/
@Service
public class ChartBiz {
    @Reference(version = "1.0.0")
    ClassService classService;
    
    /** 
    * @Description: 统计各班学生的人数
    * @author: chenzhen
    * @Date: 2019/9/30 0030 
    */ 
    public List<Chart> getChart() {
        List<SClass> sClassList = classService.listSClassByOrder();
        List<Chart> chartList = new ArrayList<>();
        for (SClass sclass:
             sClassList) {
            Chart chart = new Chart();
            chart.setName(sclass.getClassName());
            chart.setValue(sclass.getClassCount());
            chartList.add(chart);
        }
        return chartList;
    }

    


}
