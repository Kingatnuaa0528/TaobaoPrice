package com.king.test.mvc.dao;

import com.king.program.mvc.dao.impl.UserDAOImpl;
import com.king.program.mvc.pojo.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by gaohanqing on 2017/1/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value= "classpath:datasource/dataSource.xml")
public class UserDAOTest {

    @Resource
    private UserDAOImpl userDAOImpl;

    @Test
    public void testInsertUser()
    {
        String username = "test2";
        String password = "test";
        UserDO userDO = new UserDO();
        userDO.setUsername(username);
        userDO.setPassword(password);
        int result = userDAOImpl.insert_user(userDO);
        System.out.println("result :  " + result);
    }
}
