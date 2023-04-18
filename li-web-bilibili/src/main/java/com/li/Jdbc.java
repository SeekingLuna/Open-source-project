package com.li;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc {
//    public static void main(String[] args) {
//        insert();
//    }

    public void insert() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立数据库连接
            String url = "jdbc:mysql://47.115.229.205:3306/bilibili";
            String username = "root";
            String password = "3B8E9839C03208161D7990979CF51104";
            conn = DriverManager.getConnection(url, username, password);

            // 创建PreparedStatement对象并执行插入
            String sql = "INSERT INTO user (midid, name,follower, following ,sign) VALUES (?, ?, ?,?, ?)";
            stmt = conn.prepareStatement(sql);
            User user = Main.userArrayList.get(0);
            stmt.setInt(1, user.getMidid());
            stmt.setString(2, user.getName());
            stmt.setInt(3, user.getFollowing());

            stmt.setInt(4, user.getFollower());
            stmt.setString(5, user.getSign());
            int rowsAffected = stmt.executeUpdate();

            // 判断是否插入成功
            if (rowsAffected > 0) {
                System.out.println("插入成功");
                System.out.println(user.toString());
            } else {
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接和资源
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
}
