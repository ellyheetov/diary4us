package org.diary4us.test;

import org.diary4us.config.DBconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

    public static void main(String[] args){
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
