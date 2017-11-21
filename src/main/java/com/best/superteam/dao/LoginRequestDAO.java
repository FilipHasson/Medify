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
        String query = "SELECT user_id, user_email, user_hash FROM USERS WHERE user_id= ?";

        Connection connection = dao.connect();
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1,userID);

            ResultSet rs = statement.executeQuery();

            rs.next();
            l = getLoginRequestFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    public LoginRequest findByUserEmail(String email){
        DAO dao = new DAO();
        LoginRequest l = null;
        PreparedStatement statement = null;
        String query = "SELECT user_id, user_email, user_hash FROM USERS WHERE user_email = ?";

        Connection connection = dao.connect();
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,email);

            ResultSet rs = statement.executeQuery();

            rs.next();
            l = getLoginRequestFromResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    private LoginRequest getLoginRequestFromResultSet (ResultSet rs){
        try {
            return new LoginRequest(rs.getString("USER_EMAIL"),
                    LoginRequest.hexStringToByteArray(rs.getString("USER_HASH")));
        } catch (SQLException e){
            return null;
        }
    }
}
