package com.smapley.web.platform.base.controller;

import com.smapley.web.platform.base.entity.BaseEntity;
import com.smapley.web.platform.base.entity.SimpleEntity;
import com.smapley.web.platform.base.response.BaseResponse;
import com.smapley.web.platform.base.response.ResponseType;
import com.smapley.web.platform.base.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wuzhixiong on 2017/6/3.
 */
public class BaseController<T extends BaseEntity> {

    @Autowired
    private IBaseService<T> baseService;

    protected IBaseService<T> getService() {
        return baseService;
    }


    @RequestMapping("saveOrUpdate")
    public BaseResponse saveOrUpdate(@RequestBody T entity) {
        getService().saveOrUpdate(entity);
        return baseResponse();
    }

    @RequestMapping("delete")
    public BaseResponse delete(@RequestBody T entity) {
        getService().delete(entity);
        return baseResponse();
    }


    @RequestMapping("getListByName")
    public BaseResponse getListByName(@RequestBody SimpleEntity entity) {
        return baseResponse(getService().getListByName(entity.getName()));
    }

    @RequestMapping("getAll")
    public BaseResponse getAll() {
        return baseResponse(getService().getAll());
    }

    protected BaseResponse baseResponse() {
        return baseResponse(ResponseType.SUCCESS);
    }

    protected BaseResponse baseResponse(ResponseType type) {
        return new BaseResponse(type);
    }

    protected BaseResponse baseResponse(Object data) {
        BaseResponse response = baseResponse();
        response.setData(data);
        return response;
    }


}
