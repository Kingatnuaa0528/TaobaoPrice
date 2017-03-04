package com.king.program.mvc.pojo;

import java.util.Date;

/**
 * Created by gaohanqing on 2017/2/20.
 */
public class CommodyPriceDO {

    private int c_id;

    private Date createTime;

    private double price;

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
