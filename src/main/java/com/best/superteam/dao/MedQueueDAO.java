package com.best.superteam.dao;

import com.best.superteam.object.MedQueueItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class MedQueueDAO {

    public List<MedQueueItem> findAll() {
        DAO dao = new DAO();
        List<MedQueueItem> queueItems = new ArrayList<>();
        PreparedStatement statement = null;
        Connection conn = dao.connect();
        String query = "SELECT * FROM MED_QUEUE";
        try {
            statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                queueItems.add(getItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queueItems;
    }

    public List<MedQueueItem> findByUserID(int userID) {
        DAO dao = new DAO();
        List<MedQueueItem> queueItems = new ArrayList<>();
        PreparedStatement statement = null;
        Connection conn = dao.connect();
        String query = "SELECT * FROM MED_QUEUE WHERE USER_ID = ?";
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, Integer.toString(userID));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                queueItems.add(getItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queueItems;
    }

    public List<MedQueueItem> findByUserIDToday(int userID) {
        DAO dao = new DAO();
        List<MedQueueItem> queueItems = new ArrayList<>();
        PreparedStatement statement = null;
        Connection conn = dao.connect();
        String query = "SELECT * FROM MED_QUEUE WHERE USER_ID = ? AND SCH_DATE = CURRENT_DATE";
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, Integer.toString(userID));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                queueItems.add(getItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queueItems;
    }

    public List<MedQueueItem> findByUserIDThisWeek(int userID) {
        DAO dao = new DAO();
        List<MedQueueItem> queueItems = new ArrayList<>();
        PreparedStatement statement = null;
        Connection conn = dao.connect();
        String query = "SELECT * FROM MED_QUEUE WHERE USER_ID = ? AND SCH_DATE <= (SELECT DATETIME('now', '7 day'))";
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, Integer.toString(userID));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                queueItems.add(getItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queueItems;
    }

    private MedQueueItem getItemFromResultSet(ResultSet rs) {
        try {
            LocalDate date = LocalDate.parse(rs.getString("SCH_DATE"));
            String timeStr = rs.getString("SCH_TIME");
            LocalTime time = LocalTime.of(  Integer.parseInt(timeStr.substring(0,2)),
                                            Integer.parseInt(timeStr.substring(2,4)),
                                            Integer.parseInt(timeStr.substring(4,6)));
            return  new MedQueueItem(
                    rs.getInt("USER_ID"),
                    rs.getInt("MED_ID"),
                    date,
                    time);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
