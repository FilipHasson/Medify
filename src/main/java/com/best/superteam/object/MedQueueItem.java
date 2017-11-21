package com.best.superteam.object;

import java.time.LocalDate;
import java.time.LocalTime;

public class MedQueueItem {

    int userID;
    int medID;
    LocalDate schDate;
    LocalTime schTime;

    public MedQueueItem (int userID, int medID, LocalDate schDate, LocalTime schTime) {
        this.userID = userID;
        this.medID = medID;
        this.schDate = schDate;
        this.schTime = schTime;
    }

    @Override
    public String toString() {
        return userID + " : " + medID + " : " + schDate + " : " + schTime;
    }
}
