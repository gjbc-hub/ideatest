package com.example.web4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sql {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/bookstore?allowPublicKeyRetrieval=true";
        String user = "root";
        String pwd = "123456";

        try {
            Connection conn = DriverManager.getConnection(url, user, pwd);
            Statement stmt = conn.createStatement();
            String sql = "select * from book";

            ResultSet rs = stmt.executeQuery(sql);
            String Sql = "select * from name";
            while (rs.next()) {
                String name = rs.getString("name");
                String pub = rs.getString("pub");

                System.out.println("书名：" + name + "  出版社：" + pub);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}