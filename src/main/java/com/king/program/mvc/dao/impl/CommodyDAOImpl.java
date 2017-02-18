package com.king.program.mvc.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.king.program.mvc.dao.CommodyDAO;
import com.king.program.mvc.pojo.CommodyDO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohanqing on 2017/1/5.
 */

@Component
public class CommodyDAOImpl extends SqlMapClientDaoSupport implements CommodyDAO {

    @Resource
    private SqlMapClient sqlMapClient;
    @PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClient);
    }

    @Override
    public int insert_commody(CommodyDO commodyDO) {
        Object result = getSqlMapClientTemplate().insert("insert_commody", commodyDO);
        return (Integer)result;
    }

    @Override
    public CommodyDO query_commody_byId(int c_id) {
        CommodyDO result = (CommodyDO)getSqlMapClientTemplate().queryForObject("select_cid", c_id);
        return result;
    }

    @Override
    public CommodyDO query_commody_byUrl(String url) {
        Object result = getSqlMapClientTemplate().queryForObject("select_url", url);
        if(result == null) return null;
        else return (CommodyDO)result;
    }
}
