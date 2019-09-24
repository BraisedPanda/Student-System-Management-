package com.braisedpanda.student.management.system.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="classgradescard")
public class ClassGradesCard implements Serializable{
    private static final long serialVersionUID = -2427478352147733784L;
    @Id
    @Column(name="classGradesCardId")
    private String classGradesCardId;
    @Column(name="classId")
    private String classId;
    @Column(name="testTime")
    private String testTime;
    @Column(name="testDescribe")
    private String testDescribe;


    }

