package com.smapley.web.platform.user.entity;

import com.smapley.web.platform.BaseStatus;
import com.smapley.web.platform.base.entity.SimpleEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by EricNts on 2017/6/3.
 */
@Entity
@Table(name = "t_base_user")
public class User extends SimpleEntity {

    private String nickname;
    private String password;
    private String salt;
    @Enumerated(value = EnumType.STRING)
    private BaseStatus status;

    @Transient
    private List<String> roleIds;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public BaseStatus getStatus() {
        return status;
    }

    public void setStatus(BaseStatus status) {
        this.status = status;
    }

    public String getCredentialsSalt() {
        return getName() + salt;
    }
}
