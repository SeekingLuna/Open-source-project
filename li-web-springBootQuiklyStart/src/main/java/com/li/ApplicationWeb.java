package com.li;

import com.alibaba.druid.pool.DruidDataSource;
import com.li.dao.impl.EmpDaoA;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication()
@MapperScan(value = "com/li/dao")
public class ApplicationWeb {
    public static void main(String[] args) {
//        容器
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationWeb.class, args);


    }

//    @Bean
//    public DataSource datasource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUsername("root");
//        druidDataSource.setUrl("jdbc:mysql://47.115.229.205:3306/user_info");
//        druidDataSource.setPassword("3B8E9839C03208161D7990979CF51104");
//        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        return druidDataSource;
//    }
}
