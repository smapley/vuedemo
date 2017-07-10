package com.smapley.web.platform.menu.entity;

import com.smapley.web.platform.base.entity.TreeEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by EricNts on 2017/6/3.
 */
@Entity
@Table(name = "t_base_menu")
public class Menu extends TreeEntity {

    private String viewName;
    private String icon;


    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
