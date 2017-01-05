package com.king.program.mvc.dao;

import com.king.program.mvc.pojo.UserRecordDO;

import java.util.List;

/**
 * Created by gaohanqing on 2017/1/3.
 */
public interface UserRecordDAO {

    public int insert_record(UserRecordDO userRecordDO);

    public List<Integer> query_by_uid(int u_id);
}
