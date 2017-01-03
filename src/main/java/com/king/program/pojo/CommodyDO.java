package com.king.program.pojo;

import java.util.Date;
import java.util.Map;

/**
 * Created by gaohanqing on 2017/1/3.
 */
public class CommodyDO {

    private String c_id;

    private String url;

    private Date create_time;

    private double price;

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
