package com.king.program.mvc.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.king.program.mvc.dao.UserDAO;
import com.king.program.mvc.pojo.UserDO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by gaohanqing on 2017/1/5.
 */
public class UserDAOImpl extends SqlMapClientDaoSupport implements UserDAO {

    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;
    @PostConstruct

    @Override
    public int insert_user(UserDO userDO) {
        Object result = getSqlMapClientTemplate().insert("insert_user", userDO);
        return (Integer)result;
    }

    @Override
    public String query_password(String username) {
        String result = (String)(getSqlMapClientTemplate().queryForObject("select_password", username));
        return result;
    }

    @Override
    public int query_id(String username) {
        int result = (Integer)(getSqlMapClientTemplate().queryForObject("select_uid", username));
        return result;
    }
}
