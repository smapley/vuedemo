package com.smapley.web.platform.menu.service;

import com.smapley.web.platform.base.service.IBaseService;
import com.smapley.web.platform.menu.entity.Menu;

import java.util.Set;

/**
 * Created by EricNts on 2017/6/3.
 */
public interface IMenuService extends IBaseService<Menu> {
    Set<String> findPermissions(Set<String> menuIds);
}
