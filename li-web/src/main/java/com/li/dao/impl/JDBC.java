package com.li.dao.impl;

import com.li.domain.User03;

import java.sql.*;
import java.util.ArrayList;

public class JDBC {
    // 数据库连接信息
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/testdb1";
    static final String USER = "root";
    static final String PASS = "root";


    public static void main(String[] args) {

    }

    public ArrayList<User03> extracted() {
        ArrayList<User03> user03ArrayList = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();
            String sql = "select * from user";
            ResultSet rs = stmt.executeQuery(sql);

            // 处理结果集
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String username = rs.getNString("username");
                String password = rs.getNString("password");
                String email = rs.getNString("email");
                String gender = rs.getNString("gender");
                String country = rs.getNString("country");
                double height = rs.getDouble("height");
                double weight = rs.getDouble("weight");
                user03ArrayList.add(new User03(id, username, password, email, age, gender, height, weight, country));
            }
            rs.close();
//
//            // 执行修改
//            System.out.println("更新数据...");
//            String updateSql = "UPDATE student SET age = age + 1 WHERE id = 1";
//            int rows = stmt.executeUpdate(updateSql);
//            System.out.println(rows + " 行受影响");

            // 关闭资源
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
//        for (User03 user03 : user03ArrayList) {
//            System.out.println(user03.toString());
//        }
        System.out.println("Goodbye!");
        return user03ArrayList;
    }
}