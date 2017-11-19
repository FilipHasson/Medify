package com.best.superteam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    public static void connect (){
        Connection connection = null;
        try {
            // REPLACE THIS WITH YOUR OWN DATABASE PATH
            String url = "jdbc:sqlite:C:/Users/filip/IdeaProjects/BestSuperTeam/database/bestsuperteam.db";
            connection = DriverManager.getConnection(url);

            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
