package com.best.superteam.dao;

import com.best.superteam.object.Medication;
import com.best.superteam.object.User;

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
}
