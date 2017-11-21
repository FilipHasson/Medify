package com.best.superteam.dao;

import com.best.superteam.object.LoginRequest;
import com.best.superteam.object.User;
import com.best.superteam.object.Enumeration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Filip Hasson
 */
public class UserDAO {

    public List<User> findAll() {
        DAO dao = new DAO();
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;

        Connection conn = dao.connect();
        String query = "SELECT * FROM USERS";
        try {
            statement = conn.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                users.add(new User(
                        rs.getString("USER_GIVEN_NAMES"),
                        rs.getString("USER_FAMILY_NAME"),
                        Integer.parseInt(rs.getString("USER_ID")),
                        rs.getString("USER_EMAIL"),
                        Integer.parseInt(rs.getString("USER_TYPE")),
                        Integer.parseInt(rs.getString("USER_MEDALS")),
                        Integer.parseInt(rs.getString("USER_STREAK"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean addUser(User user, LoginRequest loginRequest) {
        DAO dao = new DAO();
        PreparedStatement statement = null;
        Connection connect = dao.connect();
        String query = "";
//        try {
//            statement = connect.prepareStatement(query)
//        }

        return true;
    }
}


