package com.smapley.web.platform.base.service.impl;

import com.smapley.web.platform.base.dao.IBaseDao;
import com.smapley.web.platform.base.entity.BaseEntity;
import com.smapley.web.platform.base.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by EricNts on 2017/6/3.
 */
public class BaseService<T extends BaseEntity> implements IBaseService<T> {

    @Autowired
    private IBaseDao<T> baseDao;

    protected IBaseDao<T> getDao() {
        return baseDao;
    }

    public void save(T entity) {
        baseDao.save(entity);
    }

    public void delete(String id) {
        baseDao.delete(id);
    }

    public void delete(T entity) {
        baseDao.delete(entity);
    }

    public void update(T entity) {
        baseDao.update(entity);
    }

    public T getById(String id) {
        return baseDao.getById(id);
    }

    @Override
    public T getByName(String name) {
        return baseDao.getByName(name);
    }

    public List<T> getByIds(String[] ids) {
        return baseDao.getByIds(ids);
    }

    public List<T> getAll() {
        return baseDao.getAll();
    }

    @Override
    public List<T> getList(String params) {
        return baseDao.getList(params);
    }
}
