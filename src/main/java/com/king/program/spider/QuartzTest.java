package com.king.program.spider;

/**
 * Created by gaohanqing on 2017/2/17.
 */

import com.king.program.mvc.pojo.CommodyInfoDO;
import com.king.program.mvc.pojo.UserDO;
import com.king.program.mvc.service.CommodyService;
import com.king.program.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;
import java.util.List;


public class QuartzTest {

    @Autowired
    private CommodyService commodyService;

    @Autowired
    private UserService userService;


    protected void execute() throws IOException, InterruptedException{
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:dispatcher-servlet.xml");
        userService = (UserService)ac.getBean("userService");
        commodyService = (CommodyService)ac.getBean("commodyService");

        /*/--------------------insert new user-------------------------
        UserDO user = new UserDO();
        user.setUsername("king");
        user.setPassword("123456");
        if(commodyService == null) System.out.println("null");
        userService.insertNewUser(user);
        //------------------------------------------------------------

        CommodyInfoDO commodyInfoDO = new CommodyInfoDO();
        commodyInfoDO.setTitle("title1");
        commodyInfoDO.setUrl("https://item.taobao.com/item.htm?spm=a219r.lm5704.14.1.EN7OgY&id=43834950159&ns=1&abbucket=12#detail");

        commodyService.insertNewCommody("king", commodyInfoDO);*/

        List<CommodyInfoDO> commodyList = commodyService.getAllCommodies();

        for(CommodyInfoDO commody : commodyList){
            int c_id = commody.getC_id();
            String url = commody.getUrl();

            CaptureCommodyPriceThread cThread = new CaptureCommodyPriceThread();
            cThread.setUrl(url);

            int cycleNum = 1;
            cThread.run();
            cThread.join(20000);

            /*若当前线程没有正确返回结果，则重新new一个，重新执行*/
        }
    }

    public static void main(String[] args){
        QuartzTest test = new QuartzTest();

        try {
            test.execute();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
