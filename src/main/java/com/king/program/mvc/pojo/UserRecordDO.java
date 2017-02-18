package com.king.program.mvc.pojo;

import java.util.Date;

/**
 * Created by gaohanqing on 2017/1/3.
 */
public class UserRecordDO {

    private int u_id;

    private int c_id;

    private Date create_time;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
