package com.braisedpanda.student.management.system.sclass.service;


import com.braisedpanda.student.management.system.commons.utils.PageHelperUtils;
import com.braisedpanda.student.management.system.sclass.mapper.ClassMapper;
import com.braisedpanda.student.management.system.domain.model
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service(version="1.0.0")
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;

   /** 
   * @Description: 插入班级 
   * @Param:  
   * @return: 
   * @Date: 2019/8/22 0022 
   */ 

    public void insertClass(SClass sclass) {
        classMapper.insert(sclass);
    }
    
    
   /** 
   * @Description: 查找所有的班级 
   * @Param:  
   * @return: 
   * @Date: 2019/8/22 0022 
   */ 

    public List<SClass> listSClass() {
        List<SClass> classList = classMapper.selectAll();
        return classList;
    }


    /** 
    * @Description: 根据班级的classid值删除班级 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public void deleteSClassById(SClass sclass) {
        classMapper.deleteByPrimaryKey(sclass);

    }

    /** 
    * @Description: 根据classid查找出对应的class 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public SClass getSClassById(SClass sclass) {
        SClass sClass = classMapper.selectByPrimaryKey(sclass);
        return sClass;
    }

    /** 
    * @Description: 更新班级信息 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public void updateSClassById(SClass sClass) {
         classMapper.updateByPrimaryKey(sClass);
    }


    /** 
    * @Description: 获取所有班级的class
    * @Param:  
    * @return: 
    * @Date: 2019/8/22 0022 
    */ 

    public List<String> listClassId() {
        List<String> list =  classMapper.listClassId();
        return list;

    }
    /**
    * @Description: 统计出所有班级的数目
    * @Param:
    * @return:
    * @Date: 2019/8/26 0026
    */

    public int countSClass() {
        SClass c = new SClass();
        int count = classMapper.selectCount(c);
        return count;
    }

    /**
    * @Description: 分页查询班级
    * @author: chenzhen
    * @Date: 2019/9/21 0021
    */
    public List<SClass> pageClass(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<SClass> sClassList = classMapper.selectAll();
        return PageHelperUtils.getResultList(sClassList);
    }
}
