package com.king.program.dao;

import com.king.program.pojo.UserDO;

/**
 * Created by gaohanqing on 2017/1/3.
 */
public interface UserDAO {

    public int insert_user(UserDO userDO);

    public String query_password(String username);

    public int query_id(String username);

    public int delete_user(String username);

    public int update_username(String username);

    public int update_password(String username);
}
