package com.king.program.mvc.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.king.program.mvc.dao.CommodyPriceDAO;
import com.king.program.mvc.pojo.CommodyPriceDO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohanqing on 2017/2/20.
 */

@Component
public class CommodyPriceDAOImpl extends SqlMapClientDaoSupport implements CommodyPriceDAO {

    @Resource
    private SqlMapClient sqlMapClient;
    @PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClient);
    }


    @Override
    public int insertCommodyPrice(CommodyPriceDO commodyPriceDO) {
        Object result = getSqlMapClientTemplate().insert("insert_commodyPrice", commodyPriceDO);
        if(result != null) return (Integer)result;
        return 0;
    }

    @Override
    public List<CommodyPriceDO> queryCommodyPrice(int c_id) {
        List<CommodyPriceDO> result = getSqlMapClientTemplate().queryForList("select_byId", c_id);
        return result;
    }
}
