package com.king.test.mvc.dao;

import com.king.program.mvc.dao.CommodyInfoDAO;
import com.king.program.mvc.pojo.CommodyInfoDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by gaohanqing on 2017/1/22.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value= "classpath:dataSource.xml")
public class CommodyInfoDAOTest {

    @Autowired
    private CommodyInfoDAO commodyInfoDAO;

    @Test
    public void testInsertCommody()
    {
        CommodyInfoDO commodyInfoDO = new CommodyInfoDO();
        commodyInfoDO.setTitle("aaaaa");
        commodyInfoDO.setUrl("aaaaaaaa");

        int result = commodyInfoDAO.insert_commody(commodyInfoDO);

        System.out.println(result);
    }

    @Test
    public void testQueryUrl()
    {
        String url = "aaaaa";
        System.out.println(commodyInfoDAO.query_commody_byUrl(url));
    }
}
