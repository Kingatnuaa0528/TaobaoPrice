package com.king.program.mvc.service;

import com.king.program.mvc.pojo.CommodyInfoDO;
import com.king.program.mvc.pojo.CommodyPriceDO;

import java.util.List;

/**
 * Created by gaohanqing on 2017/2/20.
 */
public interface CommodyService {

    //在commody_info表中插入一条新的商品
    int insertNewCommody(String username, CommodyInfoDO commodyInfoDO);

    //为一个商品更新其价格，在commody_price中插入一条新的纪录
    int updateCommodyPrice(CommodyPriceDO commodyPriceDO);

    //获取用户的所有商品
    List<CommodyInfoDO> getUserCommodies(String username);

    List<CommodyInfoDO> getAllCommodies();

    List<CommodyPriceDO> getCommodyHistoryPrice(int c_id);
}
