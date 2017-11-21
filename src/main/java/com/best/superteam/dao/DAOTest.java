package com.best.superteam.dao;

import com.best.superteam.object.Enumeration;
import com.best.superteam.object.LoginRequest;
import com.best.superteam.object.MedQueueItem;
import com.best.superteam.object.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class DAOTest {
//This is the default unit test, should print out all the users in the Users table
//    @Test
    public void printUserTable(){
        UserDAO dao = new UserDAO();
        List<User> users = dao.findAll();

        for (User user : users)
            System.out.println(user);

    }

    @Test
    public void addExistingUser(){
        UserDAO dao = new UserDAO();
        User u = templateUser();
        LoginRequest l = templateLoginRequest();

        int r = dao.addUser(u,l);
        System.out.println(r+ " rows have been updated");
    }

    @Test
    public void removeThenAddUser(){
        UserDAO dao = new UserDAO();
        User u = templateUser();
        LoginRequest l = templateLoginRequest();

        int r = dao.removeByUser(u);
        System.out.println(r+ " rows have been updated");
        printUserTable();
        r = dao.addUser(u,l);
        System.out.println(r+ " rows have been updated");
        printUserTable();
    }

    private User templateUser(){
        String firstName = "Bill Joe";
        String lastName = "Simpson";
        String email = "bjs4life@gmail.com";
        Enumeration.userTypes type = Enumeration.userTypes.CLIENT;
        int medals = 3;
        int streak =4;
        return new User (firstName,lastName,email,type,medals,streak);
    }

    private LoginRequest templateLoginRequest(){
        String email = "bjs4life@gmail.com";
        String password = "!Testing123";
        return new LoginRequest(email,password);
    }
    //@Test
    public void queueDAOTest() {
        MedQueueDAO dao = new MedQueueDAO();
        List<MedQueueItem> queue = dao.findAll();
        System.out.println("\tfindAll():");
        for (MedQueueItem item : queue)
            System.out.println(item);
        System.out.println();

        queue = dao.findByUserID(1);
        System.out.println("\tfindByUserID():");
        for (MedQueueItem item : queue)
            System.out.println(item);
        System.out.println();
        queue = dao.findByUserID(2);
        for (MedQueueItem item : queue)
            System.out.println(item);
        System.out.println();

        queue = dao.findByUserIDToday(1);
        System.out.println("\tfindByUserIDToday():");
        for (MedQueueItem item : queue)
            System.out.println(item);
        System.out.println();
        queue = dao.findByUserIDToday(2);
        for (MedQueueItem item : queue)
            System.out.println(item);
        System.out.println();

        queue = dao.findByUserIDThisWeek(1);
        System.out.println("\tfindByUserIDThisWeek():");
        for (MedQueueItem item : queue)
            System.out.println(item);
        System.out.println();
        queue = dao.findByUserIDThisWeek(2);
        for (MedQueueItem item : queue)
            System.out.println(item);
        System.out.println();
    }
}