package com.best.superteam.object;

import java.time.LocalDate;

public class MedScheduleItem {
    private int userId;
    private int medId;
    private String time;
    private LocalDate startDate;
    private LocalDate endDate;
    private String desc;
    private int dosage;
    private String days;

    public MedScheduleItem(int userId, int medId, String time, LocalDate startDate, LocalDate endDate, String desc, int dosage, String days) {
        this.userId = userId;
        this.medId = medId;
        this.time = time;
        this.startDate = startDate;
        this.endDate = endDate;
        this.desc = desc;
        this.dosage = dosage;
        this.days = days;
    }

    public int getUserId(){
        return this.userId;
    }

    public int getMedId() {
        return medId;
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
}
