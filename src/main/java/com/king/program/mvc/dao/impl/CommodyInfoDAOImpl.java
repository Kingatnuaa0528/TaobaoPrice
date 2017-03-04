package com.king.program.mvc.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.king.program.mvc.dao.CommodyInfoDAO;
import com.king.program.mvc.pojo.CommodyInfoDO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohanqing on 2017/1/5.
 */

@Component
public class CommodyInfoDAOImpl extends SqlMapClientDaoSupport implements CommodyInfoDAO {

    @Resource
    private SqlMapClient sqlMapClient;
    @PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClient);
    }

    @Override
    public int insert_commody(CommodyInfoDO commodyInfoDO) {
        Object result = getSqlMapClientTemplate().insert("insert_commodyInfo", commodyInfoDO);
        return (Integer)result;
    }

    @Override
    public CommodyInfoDO query_commody_byId(int c_id) {
        CommodyInfoDO result = (CommodyInfoDO)getSqlMapClientTemplate().queryForObject("select_cid", c_id);
        return result;
    }

    @Override
    public CommodyInfoDO query_commody_byUrl(String url) {
        Object result = getSqlMapClientTemplate().queryForObject("select_url", url);
        if(result == null) return null;
        else return (CommodyInfoDO)result;
    }

    @Override
    public List<CommodyInfoDO> queryAllCommodies() {
        List<CommodyInfoDO> result = getSqlMapClientTemplate().queryForList("select_all");
        return result;
    }
}
