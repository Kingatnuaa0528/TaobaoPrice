package com.king.program.mvc.service;

import com.king.program.mvc.dao.impl.CommodyDAOImpl;
import com.king.program.mvc.dao.impl.UserDAOImpl;
import com.king.program.mvc.dao.impl.UserRecordDAOImpl;
import com.king.program.mvc.pojo.CommodyDO;
import com.king.program.mvc.pojo.UserRecordDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohanqing on 2017/1/21.
 */

@Component
public class CommodyService {

    @Resource
    private CommodyDAOImpl commodyDAO;

    @Resource
    private UserDAOImpl userDAO;

    @Resource
    private UserRecordDAOImpl userRecordDAO;

    public int insertCommody(String username, CommodyDO commodyDO)
    {
        UserRecordDO userRecordDO = new UserRecordDO();
        int c_id = -1;
        int u_id = userDAO.query_id(username);
        if(u_id == -1) return -1;

        CommodyDO queryResult = commodyDAO.query_commody_byUrl(commodyDO.getUrl());

        if(queryResult != null){
            c_id = queryResult.getC_id();
        }
        else{
            c_id = commodyDAO.insert_commody(commodyDO);
        }

        userRecordDO.setC_id(c_id);
        userRecordDO.setU_id(u_id);

        userRecordDAO.insert_record(userRecordDO);
        return 1;
    }

    public List<CommodyDO> getUserCommodies(String username)
    {
        int u_id = userDAO.query_id(username);
        if(u_id == -1) return null;

        List<CommodyDO> result = new ArrayList<CommodyDO>();

        List<Integer> c_idList = userRecordDAO.query_by_uid(u_id);

        for(int i = 0; i < c_idList.size(); i++)
        {
            CommodyDO temp = commodyDAO.query_commody_byId(c_idList.get(i));
            result.add(temp);
        }
        return result;
    }

    public List<CommodyDO> getAllCommodies()
    {

    }
}
