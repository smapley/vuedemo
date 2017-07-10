package com.smapley.web.platform.user.service;

import com.smapley.web.platform.base.service.IBaseService;
import com.smapley.web.platform.user.entity.User;

import java.util.Set;


/**
 * Created by wuzhixiong on 2017/6/3.
 */
public interface IUserService extends IBaseService<User> {

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
