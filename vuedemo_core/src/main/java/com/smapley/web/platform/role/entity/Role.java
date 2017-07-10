package com.smapley.web.platform.role.entity;

import com.smapley.web.platform.BaseStatus;
import com.smapley.web.platform.base.entity.SimpleEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by EricNts on 2017/6/3.
 */
@Entity
@Table(name = "t_base_role")
public class Role extends SimpleEntity{

    private String description;
    @Enumerated(value = EnumType.STRING)
    private BaseStatus state;

    @Transient
    private List<String> MenuIds;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMenuIds() {
        return MenuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        MenuIds = menuIds;
    }

    public BaseStatus getState() {
        return state;
    }

    public void setState(BaseStatus state) {
        this.state = state;
    }
}
