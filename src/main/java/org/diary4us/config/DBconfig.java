package org.diary4us.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.diary4us.dao")
@EnableTransactionManagement
public class DBconfig {

    //database 설정에 관련된 내용
    private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/diarydb?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private String username = "connectuser";
    private String dbpassword = "connect123!@#";

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(dbpassword);
        return dataSource;
    }
}
