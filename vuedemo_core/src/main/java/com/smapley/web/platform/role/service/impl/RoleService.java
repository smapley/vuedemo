package com.smapley.web.platform.role.service.impl;

import com.smapley.web.platform.base.service.impl.BaseService;
import com.smapley.web.platform.menu.service.IMenuService;
import com.smapley.web.platform.role.entity.Role;
import com.smapley.web.platform.role.service.IRoleService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by EricNts on 2017/6/3.
 */
@Service
public class RoleService extends BaseService<Role> implements IRoleService {

   @Autowired
   private IMenuService menuService;

    @Override
    public Set<String> findRoleNames(String[] ids) {
        if(ArrayUtils.isNotEmpty(ids)){
            Set<String> roleNames = new HashSet<String>();
            List<Role> roleList= getByIds(ids);
            for(Role role:roleList){
                roleNames.add(role.getName());
            }
            return roleNames;
        }
        return Collections.emptySet();
    }

    @Override
    public Set<String> findPermissions(String[] ids) {
        if(ArrayUtils.isNotEmpty(ids)){
            Set<String> menuIds = new HashSet<String>();
            List<Role> roleList= getByIds(ids);
            for(Role role:roleList){
                menuIds.addAll(role.getMenuIds());
            }
            return menuService.findPermissions(menuIds);
        }
        return Collections.emptySet();
    }
}
