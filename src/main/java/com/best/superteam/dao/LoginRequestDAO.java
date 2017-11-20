package com.best.superteam.dao;

import com.best.superteam.object.LoginRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Filip Hasson
 * this class retrieves the usename and password hash from the Users database
 */
public class LoginRequestDAO {
    public LoginRequest findByUserID(int userID){
        DAO dao = new DAO();
        LoginRequest l = null;
        PreparedStatement statement = null;
        String query = "SELECT USER_ID, USER_EMAIL, USER_HASH FROM USERS WHERE USER_ID = ?";

        Connection connection = dao.connect();
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1,userID);

            ResultSet rs = statement.executeQuery();

            rs.next();
            l = new LoginRequest(rs.getString("USER_EMAIL"),
                    hexStringToByteArray(rs.getString("USER_HASH")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    public LoginRequest findByUserEmail(String email){
        DAO dao = new DAO();
        LoginRequest l = null;
        PreparedStatement statement = null;
        String query = "SELECT USER_ID, USER_EMAIL, USER_HASH FROM USERS WHERE USER_EMAIL = ?";

        Connection connection = dao.connect();
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,email);

            ResultSet rs = statement.executeQuery();

            rs.next();
            l = new LoginRequest(rs.getString("USER_EMAIL"),
                    hexStringToByteArray(rs.getString("USER_HASH")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }
    
    private byte[] hexStringToByteArray(String s){
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
