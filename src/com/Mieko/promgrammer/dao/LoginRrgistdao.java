package com.Mieko.promgrammer.dao;

import com.Mieko.promgrammer.javaBean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRrgistdao {
    public User login(Connection con,User user) throws SQLException {
        User resultUser=null;
        String sql="select * from user where name=? and password=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,user.getName());
        pstmt.setString(2,user.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if (rs.next()){
            resultUser=new User();
            resultUser.setName(rs.getString("name"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }
    public boolean regist(Connection con,User user) throws SQLException {
        boolean flag=false;
        PreparedStatement pstmt=null;
        String sql="INSERT INTO user(name,password) VALUES(?,?)";
        pstmt=con.prepareStatement(sql);
        pstmt.setString(1,user.getName());
        pstmt.setString(2,user.getPassword());
        if (pstmt.executeUpdate()>0){
            flag=true;
        }
        return flag;
    }
}
