package com.best.superteam.dao;

import com.best.superteam.object.LoginRequest;
import com.best.superteam.object.User;
import com.best.superteam.object.Enumeration;
import org.sqlite.SQLiteException;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Filip Hasson
 */
public class UserDAO {

    private static final String SELECT_ALL = "SELECT * FROM USERS WHERE ";

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
                users.add(getUserFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public int addUser(User user, LoginRequest loginRequest) {
        DAO dao = new DAO();
        PreparedStatement statement = null;
        Connection connect = dao.connect();
        String query = "INSERT INTO USERS (user_given_names, user_family_name, user_birthday, user_email, user_phone," +
                "user_type, user_hash, user_medals, user_streak)" +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setDate(3,new Date(8224596));
            statement.setString(4,user.getEmail());
            statement.setString(5,user.getPhone());
            statement.setInt(6,user.getUserTypeInteger());
            statement.setString(7,LoginRequest.byteArrayToHexString(loginRequest.getPasswordHash()));
            statement.setInt(8,user.getMedals());
            statement.setInt(9,user.getStreak());
            return statement.executeUpdate();
        } catch (SQLiteException ec){
            System.out.println("Duplicate not allowed");
            return 0;
        } catch (SQLException e) {
            System.out.println("Unexpected Error:");
            e.printStackTrace();
            return 0;
        }
    }

    public List<User> findByFirstName(String name){
        return findListByStringField("user_given_names",name);
    }

    public List<User> findByLastName(String name){
        return findListByStringField("user_family_name",name);
    }

    public List<User> findByPhone(String phone){
        return findListByStringField("user_given_names",phone);
    }

    public List<User> findByStreak(int streak){
        return findListByIntField("user_streak",streak);
    }

    public List<User> findByMedals(int medals){
        return findListByIntField("user_medals",medals);
    }

    public User findByEmail(String email) {
          return findOneByStringField("user_email",email);
    }

    public User findById(int id){
        return findOneByIntField("user_id",id);
    }

    private List<User> findListByIntField (String field, int searchIndex){
        DAO dao = new DAO();
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        String query = SELECT_ALL+field+" = ?";

        Connection connection = dao.connect();
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1,searchIndex);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                users.add(getUserFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private User findOneByIntField(String field, int searchIndex){
        DAO dao = new DAO();
        User user = null;
        PreparedStatement statement = null;
        String query = SELECT_ALL+field+" = ?";

        Connection connection = dao.connect();
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1,searchIndex);

            ResultSet rs = statement.executeQuery();

            rs.next();
            user = getUserFromResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private User findOneByStringField(String field, String searchIndex){
        DAO dao = new DAO();
        User user = null;
        PreparedStatement statement = null;
        String query = SELECT_ALL+field+" = ?";

        Connection connection = dao.connect();
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,searchIndex);

            ResultSet rs = statement.executeQuery();

            rs.next();
            user = getUserFromResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private List<User> findListByStringField(String field, String searchIndex){
        DAO dao = new DAO();
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        String query = SELECT_ALL+field+" = ?";

        Connection connection = dao.connect();
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,searchIndex);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                users.add(getUserFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public int removeByUser(User user){
        return removeById(user.getUID());
    }

    public int removeByEmail(String email){
        return removeById(findByEmail(email).getUID());
    }

    public int removeById(int id){
        DAO dao = new DAO();
        PreparedStatement statement = null;
        String query = "DELETE FROM USERS WHERE user_id = ?";
        Connection connection = dao.connect();
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            return statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private User getUserFromResultSet(ResultSet rs) {
        try {
            return new User(
                    rs.getString("USER_GIVEN_NAMES"),
                    rs.getString("USER_FAMILY_NAME"),
                    Integer.parseInt(rs.getString("USER_ID")),
                    rs.getString("USER_EMAIL"),
                    rs.getString("USER_PHONE"),
                    Integer.parseInt(rs.getString("USER_TYPE")),
                    Integer.parseInt(rs.getString("USER_MEDALS")),
                    Integer.parseInt(rs.getString("USER_STREAK")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


