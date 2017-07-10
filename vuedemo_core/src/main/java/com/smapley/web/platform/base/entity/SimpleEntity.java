package com.smapley.web.platform.base.entity;

import javax.persistence.MappedSuperclass;

/**
 * Created by EricNts on 2017/6/3.
 */
@MappedSuperclass
public class SimpleEntity extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
