package com.smapley.web.platform.user.service.impl;

import com.smapley.web.platform.base.service.impl.BaseService;
import com.smapley.web.platform.role.service.IRoleService;
import com.smapley.web.platform.user.entity.User;
import com.smapley.web.platform.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

/**
 * Created by wuzhixiong on 2017/6/3.
 */
@Service
public class UserService extends BaseService<User> implements IUserService {

    @Autowired
    private IRoleService roleService;

    @Override
    public Set<String> findRoles(String username) {
        User user =getByName(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoleNames(user.getRoleIds().toArray(new String[0]));
    }

    @Override
    public Set<String> findPermissions(String username) {
        User user = getByName(username);
        if(user !=null)
            return roleService.findPermissions(user.getRoleIds().toArray(new String[0]));
        return Collections.emptySet();
    }
}
