package com.best.superteam.dao;

import com.best.superteam.object.Medication;
import org.sqlite.SQLiteException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Filip Hasson
 */
public class MedicationDAO {

    private static final String SELECT_ALL = "SELECT * FROM MEDICATIONS WHERE ";

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
                medications.add(getMedicationFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medications;
    }

    public Medication findById(int id) {
        return findOneByInt("med_id",id);
    }

    public List<Medication> findByName(String name){
        return findListByString("med_name",name);
    }

    public int addMedication(Medication m){
        DAO dao = new DAO();
        PreparedStatement statement = null;
        Connection connect = dao.connect();
        String query = "INSERT INTO medications (med_id,med_name,med_desc)" +
                "VALUES (?,?,?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setInt(1,m.getId());
            statement.setString(2,m.getName());
            statement.setString(3,m.getDescription());
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

    private Medication findOneByInt(String field, int searchIndex) {
        DAO dao = new DAO();
        Medication medication = null;
        PreparedStatement statement = null;

        Connection conn = dao.connect();
        String query = SELECT_ALL+field+" = ?";

        try {
            statement = conn.prepareStatement(query);
            statement.setInt(1,searchIndex);

            medication = getMedicationFromResultSet(statement.executeQuery());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medication;
    }

    private List<Medication> findListByInt(String field, int searchIndex) {
        DAO dao = new DAO();
        List<Medication> medications = new ArrayList<>();
        PreparedStatement statement = null;

        Connection conn = dao.connect();
        String query = SELECT_ALL+field+" = ?";
        try {
            statement = conn.prepareStatement(query);
            statement.setInt(1, searchIndex);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                medications.add(getMedicationFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medications;
    }

    private Medication findOneByString(String field, String searchIndex) {
        DAO dao = new DAO();
        Medication medication = null;
        PreparedStatement statement = null;

        Connection conn = dao.connect();
        String query = SELECT_ALL+field+" = ?";

        try {
            statement = conn.prepareStatement(query);
            statement.setString(1,searchIndex);

            medication = getMedicationFromResultSet(statement.executeQuery());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medication;
    }

    private List<Medication> findListByString(String field, String searchIndex) {
        DAO dao = new DAO();
        List<Medication> medications = new ArrayList<>();
        PreparedStatement statement = null;

        Connection conn = dao.connect();
        String query = SELECT_ALL+field+" = ?";
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, searchIndex);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                medications.add(getMedicationFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medications;
    }

    private Medication getMedicationFromResultSet(ResultSet rs){
        try {
            return new Medication(Integer.parseInt(rs.getString("MED_ID")),
                    rs.getString("MED_NAME"),
                    rs.getString("MED_DESC"));
        }  catch (SQLException e) {
            return null;
        }
    }
}
