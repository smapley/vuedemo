package com.smapley.web.platform.user.controller;

import com.smapley.web.platform.base.controller.BaseController;
import com.smapley.web.platform.user.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wuzhixiong on 2017/6/3.
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<User>{

}
