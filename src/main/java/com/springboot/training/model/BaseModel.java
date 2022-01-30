package com.springboot.training.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@MappedSuperclass
public class BaseModel {
    private Date createdOn;

    @PrePersist
    public void beforeCreate() {
        createdOn = new Date();
    }
}
