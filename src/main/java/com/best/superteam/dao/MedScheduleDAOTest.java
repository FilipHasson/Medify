package com.best.superteam.dao;


import com.best.superteam.object.MedScheduleItem;

import net.sf.cglib.core.Local;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedScheduleDAOTest {

    //    @Test
    public void connectionTest(){
        DAO dao = new DAO();

        Connection conn = dao.connect();
        dao.disconnect(conn);
    }

    //This is the default unit test, should print out all the users in the Users table
    @Test
    public void findAllTest(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findAll();

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    //    @Test
    public void findByDateRangeTest(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByDateRange(LocalDate.MIN, LocalDate.MAX);

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    //    @Test
    public void findByUserIDAndDateRangeTest(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByDateRange(LocalDate.MIN, LocalDate.MAX);

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    public void createMedScheduleItem(){
        int userID = 1;
        int medID = 1;
        String time = "HHMMSS";
        LocalDate startDate = LocalDate.MIN;
        LocalDate endDate = LocalDate.MAX;
        String desc = "Description";
        int dosage = 0;
        String days = "0";
        System.out.println("User ID: "+userID);
        System.out.println("Med ID: "+medID);
        System.out.println("Time: "+time);
        System.out.println("Start Date: "+startDate.toString());
        System.out.println("End Date: "+endDate.toString());
        System.out.println("Description: "+desc);
        System.out.println("Dosage: "+dosage);
        System.out.println("Days: "+days);

        MedScheduleItem m = new MedScheduleItem(userID, medID, time, startDate, endDate, desc, dosage, days);

    }
}
