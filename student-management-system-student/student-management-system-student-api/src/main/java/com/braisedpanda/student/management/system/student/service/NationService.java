package com.braisedpanda.student.management.system.student.service;

import com.braisedpanda.student.management.system.domain.model.Nation;

import java.util.List;


public interface NationService {


    //根据nation_id查找nation
    Nation getNationByPrimaryKey(Nation nation);

    
    //查找所有的nation
    List<Nation> listNation();
}
