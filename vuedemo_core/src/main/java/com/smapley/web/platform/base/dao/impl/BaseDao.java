package com.smapley.web.platform.base.dao.impl;

import com.smapley.web.platform.base.entity.BaseEntity;
import com.smapley.web.platform.base.dao.IBaseDao;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

/**
 * Created by EricNts on 2017/6/3.
 */
@SuppressWarnings("unchecked")
public class BaseDao<T extends BaseEntity> implements IBaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> clazz = null;

    public BaseDao() {
        //使用反射技术得到T的真实类型
        //获取当前new的对象的泛型的父类类型
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取第一个类型参数的真是类型
        this.clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(T entity) {
        getSession().save(entity);
    }

    public void delete(String id) {
        T entity = getById(id);
        if (entity != null)
            delete(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public T getById(String id) {
        if (StringUtils.isEmpty(id))
            return null;
        else
            return getSession().get(clazz, id);
    }

    @Override
    public T getByName(String name) {
        if (StringUtils.isNotEmpty(name)) {
            List list = getSession().createQuery(//
                    "FROM " + clazz.getSimpleName() + " WHERE name = (:name)")//
                    .setParameter("name", name)//
                    .list();
            if (list != null && !list.isEmpty()) {
                return (T) list.get(0);
            }
        }
        return null;
    }


    public List<T> getByIds(String[] ids) {
        if (ArrayUtils.isEmpty(ids))
            return Collections.emptyList();
        else
            return getSession().createQuery(//
                    "FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
                    .setParameterList("ids", ids)
                    .list();
    }

    public List<T> getAll() {
        return getSession().createQuery(//
                "FROM " + clazz.getSimpleName())//
                .list();
    }

    @Override
    public List<T> getListByName(String name) {
        if (StringUtils.isEmpty(name)) {
            name = "";
        }
        return getSession().createQuery(//
                "FROM " + clazz.getSimpleName() + " WHERE name LIKE (:name)")//
                .setParameter("name", "%" + name + "%")
                .list();
    }
}
