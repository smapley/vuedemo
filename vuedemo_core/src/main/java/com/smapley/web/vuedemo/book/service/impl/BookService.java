package com.smapley.web.vuedemo.book.service.impl;

import com.smapley.web.platform.base.service.impl.BaseService;
import com.smapley.web.platform.role.service.IRoleService;
import com.smapley.web.vuedemo.book.entity.Book;
import com.smapley.web.vuedemo.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

/**
 * Created by wuzhixiong on 2017/6/3.
 */
@Service
public class BookService extends BaseService<Book> implements IBookService {

    @Autowired
    private IRoleService roleService;


}
