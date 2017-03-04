package com.king.program.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by gaohanqing on 2017/3/3.
 */

/*
 *
 */
public class CaptureCommodyPriceThread extends Thread {

    /* 用于存放被抓取的商品url */
    private String url;

    /* 用于存放phantomjs脚本获取的结果 */
    private String result;

    /* 若线程正常执行，则isRegularWork=true*/
    private boolean isRegularWork = false;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResult() {
        return result;
    }

    public boolean isRegularWork() {
        return isRegularWork;
    }

    @Override
    public void run(){
        String jsPath = "phantomjs /Users/gaohanqing/program/Front_End/hello.js ";
        jsPath += url;

        try {
            Process p = Runtime.getRuntime().exec(jsPath);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sbf = new StringBuffer();
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                sbf.append(tmp);
            }
            result = sbf.toString();
            isRegularWork = true;
            return;
        }catch (IOException e){
            result = "error";
            return;
        }
    }
}
