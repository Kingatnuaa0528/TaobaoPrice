package com.king.program.mvc.dao;

import com.king.program.mvc.pojo.CommodyPriceDO;

import java.util.List;

/**
 * Created by gaohanqing on 2017/2/20.
 */
public interface CommodyPriceDAO {

    int insertCommodyPrice(CommodyPriceDO commodyPriceDO);

    List<CommodyPriceDO> queryCommodyPrice(int c_id);
}
