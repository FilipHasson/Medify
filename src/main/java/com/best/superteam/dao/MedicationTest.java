package com.best.superteam.dao;

import com.best.superteam.object.Medication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MedicationTest {

    @Test
    public void allMedicationTest() {
        MedicationDAO dao = new MedicationDAO();
        List<Medication> meds = dao.findAll();

        for (Medication med : meds)
            System.out.println(med);
    }

    @Test
    public void searchByIntTest() {
        MedicationDAO dao = new MedicationDAO();
        Medication medication = dao.findById(1);

        Assertions.assertEquals("1", Integer.toString(medication.getId()));
        Assertions.assertEquals("Asprin", medication.getName());
        Assertions.assertEquals("You already know", medication.getDescription());
    }

    @Test
    public void searchByNameTest() {
        MedicationDAO dao = new MedicationDAO();
        List<Medication> medications = dao.findByName("Asprin");

        for (Medication med : medications) {
            Assertions.assertEquals("Asprin", med.getName());
        }
    }
}
