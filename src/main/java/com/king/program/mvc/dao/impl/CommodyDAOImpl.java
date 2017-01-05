package com.king.program.mvc.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.king.program.mvc.dao.CommodyDAO;
import com.king.program.mvc.pojo.CommodyDO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohanqing on 2017/1/5.
 */
public class CommodyDAOImpl extends SqlMapClientDaoSupport implements CommodyDAO {

    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;
    @PostConstruct

    @Override
    public int insert_commody(CommodyDO commodyDO) {
        int result = (Integer)(getSqlMapClientTemplate().insert("insert_commody", commodyDO));
        return result;
    }

    @Override
    public List<CommodyDO> query_byId(int c_id) {
        List<CommodyDO> result = getSqlMapClientTemplate().queryForList("select_price", c_id);
        return result;
    }
}
