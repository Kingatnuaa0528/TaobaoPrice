package com.king.program.mvc.service;

import com.king.program.mvc.dao.impl.UserDAOImpl;
import com.king.program.mvc.pojo.CommodyDO;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohanqing on 2017/1/6.
 */
public class UserService {

    @Resource
    private UserDAOImpl userDAOImpl;

    public boolean checkLogin(String username, String password)
    {
        String n_password = userDAOImpl.query_password(username);
        if(n_password == null || n_password.equals(password) == false) return false;
        return true;
    }

}
