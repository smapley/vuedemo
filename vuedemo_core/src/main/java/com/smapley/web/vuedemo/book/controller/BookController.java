package com.smapley.web.vuedemo.book.controller;

import com.smapley.web.platform.base.controller.BaseController;
import com.smapley.web.vuedemo.book.entity.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuzhixiong on 2017/6/3.
 */
@RestController
@RequestMapping("book")
public class BookController extends BaseController<Book>{

}
