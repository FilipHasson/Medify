package com.best.superteam.dao;

import com.best.superteam.object.MedScheduleItem;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedScheduleDAO {
    public List<MedScheduleItem> findAll(){
        DAO dao = new DAO();
        List<MedScheduleItem> m = new ArrayList<>();
        PreparedStatement statement;
        String query = "SELECT * FROM USERS";

        Connection connection = dao.connect();

        try {
            statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                m.add(getMedScheduleItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return m;
    }

    public List<MedScheduleItem> findByUserID(int userID){
        DAO dao = new DAO();
        List<MedScheduleItem> m = new ArrayList<>();
        PreparedStatement statement;
        String query = "SELECT * FROM USERS WHERE USER_ID = ?";

        Connection connection = dao.connect();

        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1,userID);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                m.add(getMedScheduleItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return m;
    }

    public List<MedScheduleItem> findByRange(LocalDate startDate, LocalDate endDate){
        DAO dao = new DAO();
        List<MedScheduleItem> m = new ArrayList<>();
        PreparedStatement statement;
        String query = "SELECT * FROM USERS WHERE SCH_START_DATE = ?, SCH_END_DATE = ?";

        Connection connection = dao.connect();

        try {
            statement = connection.prepareStatement(query);
            statement.setDate(1, Date.valueOf(startDate));
            statement.setDate(2, Date.valueOf(endDate));

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                m.add(getMedScheduleItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return m;
    }

    private MedScheduleItem getMedScheduleItemFromResultSet(ResultSet rs)
    {
        try {
            return new MedScheduleItem(Integer.parseInt(rs.getString("USER_ID")),
                    Integer.parseInt(rs.getString("MED_ID")), rs.getString("SCH_TIME"),
                    rs.getDate("SCH_START_DATE").toLocalDate(), rs.getDate("SCH_END_DATE").toLocalDate(),
                    rs.getString("SCH_DESC"), Integer.parseInt(rs.getString("SCH_DOSAGE")),
                    rs.getString("SCH_DAYS"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
