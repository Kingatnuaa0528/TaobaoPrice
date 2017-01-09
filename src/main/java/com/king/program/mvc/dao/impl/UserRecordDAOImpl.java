package com.king.program.mvc.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.king.program.mvc.dao.UserRecordDAO;
import com.king.program.mvc.pojo.UserRecordDO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohanqing on 2017/1/6.
 */
@Component
public class UserRecordDAOImpl extends SqlMapClientDaoSupport implements UserRecordDAO {

    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;
    @PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClient);
    }

    @Override
    public int insert_record(UserRecordDO userRecordDO) {
        Object result = getSqlMapClientTemplate().insert("insert_record", userRecordDO);
        return (Integer)result;
    }

    @Override
    public List<Integer> query_by_uid(int u_id) {
        List<Integer> result = getSqlMapClientTemplate().queryForList("select_cId", u_id);
        return result;
    }
}
