package com.example.web4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BookServlet")
public class HelloServlet extends HttpServlet {
//    public static void main(String args[]){
//        System.out.println("测试");
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        // 接收表单数据
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String category = request.getParameter("category");
        String price = request.getParameter("price");

        // 输出结果
        PrintWriter out = response.getWriter();
        out.println("<h2>图书信息添加成功！</h2>");
        out.println("书号：" + bookId + "<br>");
        out.println("书名：" + bookName + "<br>");
        out.println("作者：" + author + "<br>");
        out.println("出版社：" + publisher + "<br>");
        out.println("图书类别：" + category + "<br>");
        out.println("价格：" + price + "元<br>");
    }
}