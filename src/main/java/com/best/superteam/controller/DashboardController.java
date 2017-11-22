package com.best.superteam.controller;

import com.best.superteam.dao.MedScheduleDAO;
import com.best.superteam.dao.MedicationDAO;
import com.best.superteam.object.MedScheduleItem;
import com.best.superteam.object.Medication;
import org.json.simple.*;
import com.best.superteam.dao.UserDAO;
import com.best.superteam.object.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    UserDAO dao = new UserDAO();
    MedScheduleDAO medSchedDao = new MedScheduleDAO();
    MedicationDAO medDAO = new MedicationDAO();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public JSONObject displayDashboard(int uid) {
        System.out.println("Searching for user: "+uid);

        JSONObject dashboard = new JSONObject();

        User user = dao.findById(uid);
        dashboard.put("firstName", user.getFirstName());
        dashboard.put("lastName", user.getLastName());
        dashboard.put("userType", user.getUserType());
        dashboard.put("medals", user.getMedals());
        dashboard.put("streak", user.getStreak());

        LocalDate today = LocalDate.now();
        LocalTime todayTime = LocalTime.now();

        int dayOfWeekNum = today.getDayOfWeek().getValue(); //Monday=1
        int nowTime = Integer.parseInt(todayTime.getHour() + "" +  todayTime.getMinute() + "" + todayTime.getSecond());

        //List <MedScheduleItem> schedule = medSchedDao.findByDateRange(today, today.plusDays(1));
        List <MedScheduleItem> schedule = medSchedDao.findByUserID(uid);

        List<JSONObject> upcoming = new ArrayList<JSONObject>();

        for (MedScheduleItem item : schedule) {
            Medication medication = medDAO.findById(item.getMedID());

            String days = item.getDays();
            char takeToday = days.charAt(dayOfWeekNum-1);

            int pillTime = Integer.parseInt(item.getTime());

            if ((takeToday == '1')&&(nowTime <= pillTime)) {
                JSONObject medItem = new JSONObject();

                medItem.put("pillName", medication.getName());
                medItem.put("pillID", medication.getId());
                medItem.put("pillInfo", medication.getDescription());
                medItem.put("pillTime", formatTime(item.getTime()));
                medItem.put("pillDosage", item.getDosage());

                upcoming.add(medItem);
            }
        }

        dashboard.put("upcomingPills", upcoming);

        //missedMedications
        List<JSONObject> unmarked = new ArrayList<JSONObject>();

        JSONObject unmarkedItem = new JSONObject();


        System.out.println ("\n");
        System.out.println (dashboard);

        return dashboard;
    }


    private String formatTime (String time) {
        int pHour = Integer.parseInt(time.substring(0,2));
        String pTimeS = "";

        if (pHour > 12) {
            pTimeS = (pHour - 12) + ":" + time.substring(2,4) + " PM";
        } else {
            pTimeS = pHour + ":" + time.substring(2,4) + " AM";
        }

        return pTimeS;
    }
}



