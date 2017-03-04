package com.king.program.mvc.service.impl;

import com.king.program.mvc.dao.CommodyInfoDAO;
import com.king.program.mvc.dao.CommodyPriceDAO;
import com.king.program.mvc.dao.UserDAO;
import com.king.program.mvc.dao.UserRecordDAO;
import com.king.program.mvc.pojo.CommodyInfoDO;
import com.king.program.mvc.pojo.CommodyPriceDO;
import com.king.program.mvc.pojo.UserRecordDO;
import com.king.program.mvc.service.CommodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohanqing on 2017/1/21.
 */

@Component("commodyService")
public class CommodyServiceImpl implements CommodyService {

    @Autowired
    private CommodyInfoDAO commodyInfoDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRecordDAO userRecordDAO;

    @Autowired
    private CommodyPriceDAO commodyPriceDAO;

    @Override
    public int insertNewCommody(String username, CommodyInfoDO commodyInfoDO) {
        UserRecordDO userRecordDO = new UserRecordDO();
        int c_id = -1;
        int u_id = userDAO.query_id(username);
        if(u_id == -1) return -1;

        CommodyInfoDO queryResult = commodyInfoDAO.query_commody_byUrl(commodyInfoDO.getUrl());

        if(queryResult != null){
            c_id = queryResult.getC_id();
        }
        else{
            c_id = commodyInfoDAO.insert_commody(commodyInfoDO);
        }

        if(c_id == -1) return -1;

        userRecordDO.setC_id(c_id);
        userRecordDO.setU_id(u_id);

        userRecordDAO.insert_record(userRecordDO);
        return 1;
    }

    @Override
    public int updateCommodyPrice(CommodyPriceDO commodyPriceDO) {
        int result = commodyPriceDAO.insertCommodyPrice(commodyPriceDO);
        return result == 0 ? 0:1;
    }

    public List<CommodyInfoDO> getUserCommodies(String username)
    {
        int u_id = userDAO.query_id(username);
        if(u_id == -1) return null;

        List<CommodyInfoDO> result = new ArrayList<CommodyInfoDO>();

        List<Integer> c_idList = userRecordDAO.query_by_uid(u_id);

        for(int i = 0; i < c_idList.size(); i++)
        {
            CommodyInfoDO temp = commodyInfoDAO.query_commody_byId(c_idList.get(i));
            result.add(temp);
        }
        return result;
    }

    public List<CommodyInfoDO> getAllCommodies()
    {
        return commodyInfoDAO.queryAllCommodies();
    }

    @Override
    public List<CommodyPriceDO> getCommodyHistoryPrice(int c_id) {
        List<CommodyPriceDO> result = commodyPriceDAO.queryCommodyPrice(c_id);
        return result;
    }
}
