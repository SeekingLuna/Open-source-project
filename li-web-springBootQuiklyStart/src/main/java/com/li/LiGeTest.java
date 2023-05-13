package com.li;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class LiGeTest {
    public static void main(String[] args) throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");
        druidDataSource.setUrl("jdbc:mysql://47.115.229.205:3306/user_info");
        druidDataSource.setPassword("3B8E9839C03208161D7990979CF51104");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");





    }
}
