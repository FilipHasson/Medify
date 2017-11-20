package com.best.superteam.dao;

import com.best.superteam.object.LoginRequest;
import com.best.superteam.object.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOTest {

//    @Test
    public void connectionTest(){
        DAO dao = new DAO();

        Connection conn = dao.connect();
        dao.disconnect(conn);
    }

//    @Test
    public void queryTest(){
        DAO dao  = new DAO();

        String query = "SELECT * FROM USERS WHERE USER_ID = ?";

        Connection conn = dao.connect();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(query);
            statement.setInt(1,1);

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                String uid = rs.getString("USER_ID");
                String name = rs.getString("USER_FAMILY_NAME") + ", " +rs.getString("USER_GIVEN_NAMES");

                System.out.println("User " + uid + ": "+name);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void userSelectAll(){
        UserDAO dao = new UserDAO();
        List<User> users = dao.findAll();

        for (User user : users)
            System.out.println(user);

    }

    @Test
    public void createAccount(){
        String email = "passwordHashingTest@gmail.com";
        String password = "!Testing123";
        System.out.println("Email: "+email);
        System.out.println("Password: "+password);

        LoginRequest l = new LoginRequest(email,password);

    }

}