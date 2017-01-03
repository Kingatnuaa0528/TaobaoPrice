package com.king.program.dao;

import com.king.program.pojo.UserRecordDO;

import java.util.List;

/**
 * Created by gaohanqing on 2017/1/3.
 */
public interface UserRecordDAO {

    public int insert_record(UserRecordDO userRecordDO);

    public List<UserRecordDO> query_by_uid(int u_id);
}
