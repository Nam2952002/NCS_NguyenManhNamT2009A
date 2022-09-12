package com.example.ncs_nguyenmanhnamt2009a.dao.dao;

import com.example.ncs_nguyenmanhnamt2009a.dao.model.User;
import com.example.ncs_nguyenmanhnamt2009a.dao.utils.ConnectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    Connection connection = ConnectUtils.getConnection();

    public User getUser(String uName, String password){
        User user = null;

        String sql = "select * from users where username = ? and password = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, uName);

            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String name = rs.getString("username");

                String pass = rs.getString("password");

                user = new User(name, pass);
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }

        return user;
    }
}
