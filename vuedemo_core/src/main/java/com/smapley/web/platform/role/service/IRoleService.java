package com.smapley.web.platform.role.service;

import com.smapley.web.platform.base.service.IBaseService;
import com.smapley.web.platform.role.entity.Role;

import java.util.Set;

/**
 * Created by EricNts on 2017/6/3.
 */
public interface IRoleService extends IBaseService<Role> {
    Set<String> findRoleNames(String[] ids);

    Set<String> findPermissions(String[] ids);
}
