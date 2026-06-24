package com.example.web4;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/HelloServlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String url = "jdbc:mysql://localhost:3306/bookstore?allowPublicKeyRetrieval=true";
        String user = "root";
        String pwd = "123456";
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement st = conn.createStatement();;
            String sql = "select * from book where id='1'";
            ResultSet rs = st.executeQuery(sql);
            ArrayList<book> Book = new ArrayList<>();
            while (rs.next()){
                book b1 = new book();
                b1.setId(rs.getString("id"));
                b1.setName(rs.getString("name"));
                b1.setPub(rs.getString("pub"));
                Book.add(b1);
                out.println(JSON.toJSONString(b1));
//                out.println("编号：" + b1.getId());
//                out.println("书名：" + b1.getName());
//                out.println("出版社：" + b1.getPub());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
