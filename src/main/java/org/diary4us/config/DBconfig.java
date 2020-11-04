package org.diary4us.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.diary4us.web")
@EnableTransactionManagement
public class DBconfig implements TransactionManagementConfigurer {

    //database 설정에 관련된 내용
    private String driverClassName = "com.mysql.cj.jdbc.Driver";
    /*
    private String url = "jdbc:mysql://awsdiary4usdb.c9f79hwobvs4.us-east-2.rds.amazonaws.com:3306/diarydb?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private String username = "admin";
    private String dbpassword = "admin123";
    */
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
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }
    // 위 메서드에서 트랜잭션을 처리할 객체를 반환한다.
    // 이 객체는 아래처럼 PlatformTransactionManager를 반환한다.
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
