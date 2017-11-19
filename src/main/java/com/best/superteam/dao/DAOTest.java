package com.best.superteam.dao;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DAOTest {

//    @Test
//    public void connectionTest(){
//        DAO dao = new DAO();
//
//        Connection conn = dao.connect();
//        dao.disconnect(conn);
//    }

    @Test
    public void queryTest(){
        DAO dao  = new DAO();

        String select = "SELECT * FROM USERS WHERE USER_ID = ?";

        Connection conn = dao.connect();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(select);
            stmt.setInt(1,1);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String uid = rs.getString("USER_ID");
                String name = rs.getString("USER_FAMILY_NAME") + ", " +rs.getString("USER_GIVEN_NAMES");

                System.out.println("User " + uid + ": "+name);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}