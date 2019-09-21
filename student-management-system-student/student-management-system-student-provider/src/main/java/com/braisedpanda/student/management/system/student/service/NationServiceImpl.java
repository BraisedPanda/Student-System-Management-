package com.braisedpanda.student.management.system.student.service;


import com.braisedpanda.student.management.system.student.mapper.NationMapper;
import com.braisedpanda.student.management.system.student.model.po.Nation;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service(version="1.0.0")
public class NationServiceImpl implements NationService {

    @Autowired
    NationMapper nationMapper;

    /**
    * @Description: 根据nation_id查找nation
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public Nation getNationByPrimaryKey(Nation nation) {
        Nation nation2 = nationMapper.selectByPrimaryKey(nation);

        return nation2;
    }

    /**
    * @Description: 查询所有的nation
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */

    public List<Nation> listNation() {
        List<Nation> nationList = nationMapper.selectAll();

           return nationList;
    }
}
