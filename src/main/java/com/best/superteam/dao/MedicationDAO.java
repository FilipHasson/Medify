package com.best.superteam.dao;

import com.best.superteam.object.Medication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Filip Hasson
 */
public class MedicationDAO {

    public List<Medication> findAll() {
        DAO dao = new DAO();
        List<Medication> medications = new ArrayList<>();
        PreparedStatement statement = null;

        Connection conn = dao.connect();
        String query = "SELECT * FROM MEDICATIONS";
        try {
            statement = conn.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                medications.add(new Medication(
                        Integer.parseInt(rs.getString("MED_ID")),
                        rs.getString("MED_NAME"),
                        rs.getString("MED_DESC")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medications;
    }

    public Medication findByInt(int id) {
        DAO dao = new DAO();
        Medication medication = null;
        PreparedStatement statement = null;

        Connection conn = dao.connect();
        String query = "SELECT * FROM MEDICATIONS WHERE MED_ID = ?";

        try {
            statement = conn.prepareStatement(query);
            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();

            medication = new Medication(Integer.parseInt(rs.getString("MED_ID")),
                    rs.getString("MED_NAME"),
                    rs.getString("MED_DESC"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medication;
    }

    public List<Medication> findByName(String name) {
        DAO dao = new DAO();
        List<Medication> medications = new ArrayList<>();
        PreparedStatement statement = null;

        Connection conn = dao.connect();
        String query = "SELECT * FROM MEDICATIONS WHERE MED_NAME = ?";
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, name);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                medications.add(new Medication(
                        Integer.parseInt(rs.getString("MED_ID")),
                        rs.getString("MED_NAME"),
                        rs.getString("MED_DESC")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medications;
    }
}
