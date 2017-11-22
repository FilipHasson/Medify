package com.best.superteam.object;

import java.time.LocalDate;

public class MedScheduleItem {
    private int userID;
    private int medID;
    private String time;
    private LocalDate startDate;
    private LocalDate endDate;
    private String desc;
    private int dosage;
    private String days;

    public MedScheduleItem(int userID, int medID, String time, LocalDate startDate, LocalDate endDate, String desc, int dosage, String days) {
        this.userID = userID;
        this.medID = medID;
        this.time = time;
        this.startDate = startDate;
        this.endDate = endDate;
        this.desc = desc;
        this.dosage = dosage;
        this.days = days;
    }

    public int getUserID(){
        return this.userID;
    }

    public int getMedID() {
        return medID;
    }

    public String getTime() {
        return time;
    }

    public LocalDate getStartDate(){
        return this.startDate;
    }

    public LocalDate getEndDate(){
        return this.endDate;
    }

    public String getDesc() {
        return desc;
    }

    public int getDosage() {
        return dosage;
    }

    public String getDays() {
        return days;
    }

    @Override
    public String toString() {
        return "MedScheduleItem{" +
                "userID=" + userID +
                ", medID=" + medID +
                ", time='" + time + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", desc='" + desc + '\'' +
                ", dosage=" + dosage +
                ", days='" + days + '\'' +
                '}';
    }
}
