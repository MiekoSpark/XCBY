package com.Mieko.promgrammer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private String dbUrl="jdbc:mysql://localhost:3306/db_mieko_logindome?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    private String dbUsername="root";
    private String dbPassword="123456";
    private String jdbc="com.mysql.cj.jdbc.Driver";
    public Connection getCon() throws ClassNotFoundException {
        Class.forName(jdbc);
        Connection con= null;
        try {
            con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public void closeCon(Connection con) throws SQLException {
        if (con!=null){
            con.close();
        }
    }

    public static void main(String[] args) {
        DbUtil dbUtil=new DbUtil();
        try {
            dbUtil.getCon();
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
