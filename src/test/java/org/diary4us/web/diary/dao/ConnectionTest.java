package org.diary4us.web.diary.dao;

import org.diary4us.config.ApplicationConfig;
import org.diary4us.config.DBconfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class ConnectionTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void connectionTest() throws Exception{
        ApplicationContext ac = new AnnotationConfigApplicationContext(DBconfig.class);
        DataSource dataSource = ac.getBean(DataSource.class);
        Connection conn = null;

        try{
            conn = dataSource.getConnection();
            if(conn != null){
                System.out.println("Connection Accomplished");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
