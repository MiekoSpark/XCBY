package com.Mieko.promgrammer.servlet;

import com.Mieko.promgrammer.dao.LoginRrgistdao;
import com.Mieko.promgrammer.javaBean.User;
import com.Mieko.promgrammer.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("regname");
        String password=request.getParameter("regpass");
        DbUtil dbUtil=new DbUtil();
        User user=new User(name,password);
        LoginRrgistdao dao=new LoginRrgistdao();
        try {
            Connection con=dbUtil.getCon();
            try {
                if (dao.regist(con,user)) {
                    response.sendRedirect("index.html");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
