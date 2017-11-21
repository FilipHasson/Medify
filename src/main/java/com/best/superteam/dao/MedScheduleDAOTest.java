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

    @Test
    public void findAllTest(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findAll();

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    @Test
    public void findByDateRangeTest1(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByDateRange(LocalDate.of(1000,1,1), LocalDate.of(9999,12,31));

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    @Test
    public void findByDateRangeTest2(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByDateRange(LocalDate.now(), LocalDate.now());
        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    @Test
    public void findByUserIDAndDateRangeTest1(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByUserIDAndDateRange(1, LocalDate.of(1000,1,1), LocalDate.of(9999,12,31));

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    @Test
    public void findByUserIDAndDateRangeTest2(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByUserIDAndDateRange(1, LocalDate.now(), LocalDate.now());

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    @Test
    public void nullDatesTest1(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByDateRange(null, null);

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    @Test
    public void nullDatesTest2(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByDateRange(null, LocalDate.of(9999,12,31));

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    @Test
    public void nullDatesTest3(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByDateRange(LocalDate.of(1000,1,1), null);

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    @Test
    public void nullDatesTest4(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByUserIDAndDateRange(3, null, null);

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    @Test
    public void nullDatesTest5(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByUserIDAndDateRange(3, null, LocalDate.of(9999,12,31));

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

    @Test
    public void nullDatesTest6(){
        MedScheduleDAO dao = new MedScheduleDAO();
        List<MedScheduleItem> medScheduleItems = dao.findByUserIDAndDateRange(3, LocalDate.of(1000,1,1), null);

        for (MedScheduleItem medScheduleItem : medScheduleItems)
            System.out.println(medScheduleItem);
    }

//    @Test
    public void addItem(){
        MedScheduleDAO dao = new MedScheduleDAO();
        MedScheduleItem m = templateMedScheduleItem();

        int r = dao.addMedScheduleItem(m);
        System.out.println(r+ " rows have been updated");
    }


    private MedScheduleItem templateMedScheduleItem(){
        int userID = 3;
        int medID = 2;
        String time = "000000";
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.of(9999,12,31);
        String desc = "Description";
        int dosage = 0;
        String days = "1111111";

         return new MedScheduleItem(userID, medID, time, startDate, endDate, desc, dosage, days);
    }
}
