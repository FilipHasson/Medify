package com.best.superteam.dao;

import com.best.superteam.object.User;
import com.best.superteam.object.Enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filip Hasson
 */
public class UserDAO {
    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        users.add(new User("Filip","Hasson","0645445","fhasson", Enumeration.userTypes.ADMIN));
        return users;
    }
    public List<User> findById(){
        return new ArrayList<>();
    }
    public List<User> findByFullName(){
        return new ArrayList<>();
    }
    public List<User> findByFirstName(){
        return new ArrayList<>();
    }
    public List<User> findByLastName(){
        return new ArrayList<>();
    }
    public List<User> findByType(){
        return new ArrayList<>();
    }
    public boolean addUser(User user){
        return true;
    }
    public boolean updateUser(User user){
        return true;
    }
    public boolean deleteUser(User user){
        return true;
    }
}
