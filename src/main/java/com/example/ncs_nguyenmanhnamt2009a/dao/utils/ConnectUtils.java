package com.example.ncs_nguyenmanhnamt2009a.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtils {
    private static Connection connection;

    public synchronized static Connection getConnection() {
        String url = "jdbc:mysql://localhost:8889/ncs";
        String user = "root";
        String pass = "root";
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }

        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection = null;
        }
    }
}
