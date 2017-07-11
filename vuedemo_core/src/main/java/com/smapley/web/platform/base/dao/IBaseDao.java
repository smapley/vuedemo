package com.smapley.web.platform.base.dao;

import com.smapley.web.platform.base.entity.BaseEntity;

import java.util.List;

/**
 * Created by EricNts on 2017/6/3.
 */
public interface IBaseDao<T extends BaseEntity> {

    void save(T entity);

    void delete(String id);

    void delete(T entity);

    void update(T entity);

    T getById(String id);

    T getByName(String name);

    List<T> getByIds(String[] ids);

    List<T> getAll();


    List<T> getListByName(String name);
}
