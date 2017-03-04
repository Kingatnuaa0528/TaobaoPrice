package com.king.program.mvc.service;

import com.king.program.mvc.dao.UserDAO;
import com.king.program.mvc.pojo.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by gaohanqing on 2017/1/6.
 */

@Component("userService")
public class UserService {

    @Autowired
    private UserDAO userDAOImpl;

    public boolean checkLogin(String username, String password)
    {
        String n_password = userDAOImpl.query_password(username);
        if(n_password == null || n_password.equals(password) == false) return false;
        return true;
    }

    public int insertNewUser(UserDO userDO){
        return userDAOImpl.insert_user(userDO);
    }

}
