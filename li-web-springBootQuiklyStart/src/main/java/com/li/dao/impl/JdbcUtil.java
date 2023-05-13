package com.li.dao.impl;

import java.sql.*;

public class JdbcUtil {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String databasesName;
    private static final String DB_URL = "jdbc:mysql://47.115.229.205:3306/"+databasesName+"?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = "3B8E9839C03208161D7990979CF51104";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void executeSql(String sql) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String sql) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}