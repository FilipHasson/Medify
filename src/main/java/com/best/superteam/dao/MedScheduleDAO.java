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
        String query = "SELECT * FROM med_schedule";

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

    public List<MedScheduleItem> findByDateRange(LocalDate startDate, LocalDate endDate){
        DAO dao = new DAO();
        List<MedScheduleItem> m = new ArrayList<>();
        PreparedStatement statement;
        String query = "SELECT * FROM med_schedule WHERE (SCH_START_DATE BETWEEN ? AND ?) OR (SCH_END_DATE BETWEEN ? AND ?)";

        Connection connection = dao.connect();

        try {
            statement = connection.prepareStatement(query);
            statement.setDate(1, Date.valueOf(startDate));
            statement.setDate(2, Date.valueOf(endDate));
            statement.setDate(3, Date.valueOf(startDate));
            statement.setDate(4, Date.valueOf(endDate));

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

    public List<MedScheduleItem> findbyUserIDAndDateRange(int UID, LocalDate startDate, LocalDate endDate){
        DAO dao = new DAO();
        List<MedScheduleItem> m = new ArrayList<>();
        PreparedStatement statement;
        String query = "SELECT * FROM med_schedule WHERE USER_ID = ? AND (SCH_START_DATE BETWEEN ? AND ?) OR (SCH_END_DATE BETWEEN ? AND ?)";

        Connection connection = dao.connect();

        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1,UID);
            statement.setDate(2, Date.valueOf(startDate));
            statement.setDate(3, Date.valueOf(endDate));
            statement.setDate(4, Date.valueOf(startDate));
            statement.setDate(5, Date.valueOf(endDate));

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
                    rs.getInt("med_id"), rs.getString("SCH_TIME"),
                    rs.getDate("SCH_START_DATE").toLocalDate(), rs.getDate("SCH_END_DATE").toLocalDate(),
                    rs.getString("SCH_DESC"), Integer.parseInt(rs.getString("SCH_DOSAGE")),
                    rs.getString("SCH_DAYS"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
