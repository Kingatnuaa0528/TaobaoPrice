package com.king.program.mvc.dao;

import com.king.program.mvc.pojo.CommodyDO;

import java.util.List;

/**
 * Created by gaohanqing on 2017/1/3.
 */
public interface CommodyDAO {

    public int insert_commody(CommodyDO commodyDO);

    public CommodyDO query_commody_byId(int c_id);

    public CommodyDO query_commody_byUrl(String url);
}
