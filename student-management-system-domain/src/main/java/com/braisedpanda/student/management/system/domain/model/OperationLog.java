package com.braisedpanda.student.management.system.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: MicroService-of-Student-Management-System
 * @description:
 * @author: chenzhen
 * @create: 2019-09-25 13:58
 **/
@Data
@Table(name="operation_log")
public class OperationLog implements Serializable{

    private static final long serialVersionUID = -3244792232513228943L;
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="username")
    private String username;


    @Column(name="ip")
    private String ip;


    @Column(name="operation")
    private String operation;


    @Column(name="time")
    private String time;


    @Column(name="result")
    private String result;

}
