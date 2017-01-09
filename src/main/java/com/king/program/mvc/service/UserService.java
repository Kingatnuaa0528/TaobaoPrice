package com.king.program.mvc.service;

import com.king.program.mvc.dao.impl.UserDAOImpl;

import javax.annotation.Resource;

/**
 * Created by gaohanqing on 2017/1/6.
 */
public class UserService {

    @Resource
    private UserDAOImpl userDAOImpl;
}
