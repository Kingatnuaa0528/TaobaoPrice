package com.king.program.spider;

/**
 * Created by gaohanqing on 2017/2/17.
 */

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.Date;


public class QuartzTest {

    @Resource
    private
    private static int counter = 0;
    protected void execute()  {
        long ms = System.currentTimeMillis();
        System.out.println("\t\t" + new Date(ms));
        System.out.println("(" + counter++ + ")");
    }


}
