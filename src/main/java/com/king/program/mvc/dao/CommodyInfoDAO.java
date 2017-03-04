package com.king.program.mvc.dao;

import com.king.program.mvc.pojo.CommodyInfoDO;

import java.util.List;

/**
 * Created by gaohanqing on 2017/1/3.
 */
public interface CommodyInfoDAO {

    public int insert_commody(CommodyInfoDO commodyInfoDO);

    public CommodyInfoDO query_commody_byId(int c_id);

    public CommodyInfoDO query_commody_byUrl(String url);

    public List<CommodyInfoDO> queryAllCommodies();
}
