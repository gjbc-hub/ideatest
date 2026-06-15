package com.example.web4;

import com.mysql.cj.util.DnsSrv;

import java.sql.*;

public class sql {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/bookstore?allowPublicKeyRetrieval=true";
        String user = "root";
        String pwd = "123456";
        try {
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement st = conn.createStatement();
            String sql="select * from book where id='2'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println("书名:"+name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}