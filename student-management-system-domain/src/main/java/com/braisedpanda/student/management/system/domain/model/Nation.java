package com.braisedpanda.student.management.system.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="nation")
public class Nation implements Serializable{
    private static final long serialVersionUID = -7237236611324059865L;
    @Id
    @Column(name="nationId")
    private String nationId;
    @Column(name="nationName")
    private String nationName;


}
