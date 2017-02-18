package com.king.test.mvc.dao;

import com.king.program.mvc.dao.impl.CommodyDAOImpl;
import com.king.program.mvc.pojo.CommodyDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by gaohanqing on 2017/1/22.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value= "classpath:dataSource.xml")
public class CommodyDAOTest {

    @Resource
    private CommodyDAOImpl commodyDAO;

    @Test
    public void testInsertCommody()
    {
        CommodyDO commodyDO = new CommodyDO();
        commodyDO.setPrice(11.2);
        commodyDO.setUrl("aaaaaaaa");

        int result = commodyDAO.insert_commody(commodyDO);

        System.out.println(result);
    }

    @Test
    public void testQueryUrl()
    {
        String url = "aaaaa";
        System.out.println(commodyDAO.query_commody_byUrl(url));
    }
}
