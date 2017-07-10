package com.smapley.web.platform.base.entity;

import javax.persistence.MappedSuperclass;

/**
 * Created by EricNts on 2017/6/8.
 */
@MappedSuperclass
public class TreeEntity extends RecordEntity {

    private String number;
    private Boolean leaf;
    private Integer sortNo;
    private String parentId;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

}
