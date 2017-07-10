package com.smapley.web.platform.menu.service.impl;

import com.smapley.web.platform.base.service.impl.BaseService;
import com.smapley.web.platform.menu.entity.Menu;
import com.smapley.web.platform.menu.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EricNts on 2017/6/3.
 */
@Service
public class MenuService extends BaseService<Menu> implements IMenuService {
    @Override
    public Set<String> findPermissions(Set<String> menuIds) {
        Set<String> permissions = new HashSet<String>();
        for (String resourceId : menuIds) {
            Menu menu = getById(resourceId);
//            if (menu != null && !StringUtils.isEmpty(menu.getPermission())) {
//                permissions.add(menu.getPermission());
//            }
        }
        return permissions;
    }
}
