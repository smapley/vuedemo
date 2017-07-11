package com.smapley.web.vuedemo.book.entity;

import com.smapley.web.platform.BaseStatus;
import com.smapley.web.platform.base.entity.SimpleEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by EricNts on 2017/6/3.
 */
@Entity
@Table(name = "t_vue_book")
public class Book extends SimpleEntity {

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
