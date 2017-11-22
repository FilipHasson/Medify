package com.best.superteam.dao;

import com.best.superteam.config.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
    public Connection connect (){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("u fucked up");
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Constants.JDBC_URL);
//            System.out.println("DAO: JDBC Connected");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void disconnect (Connection connection){
        try {
            if (connection != null){
                connection.close();
//                System.out.println("DAO: JDBC Disconnected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
