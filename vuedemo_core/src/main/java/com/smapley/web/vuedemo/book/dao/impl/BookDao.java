package com.smapley.web.vuedemo.book.dao.impl;

import com.smapley.web.platform.base.dao.impl.BaseDao;
import com.smapley.web.vuedemo.book.dao.IBookDao;
import com.smapley.web.vuedemo.book.entity.Book;
import org.springframework.stereotype.Repository;

/**
 * Created by wuzhixiong on 2017/6/3.
 */
@Repository
public class BookDao extends BaseDao<Book> implements IBookDao {


}
