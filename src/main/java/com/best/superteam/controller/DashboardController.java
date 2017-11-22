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
import org.springframework.http.MediaType;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

// Autor: Lindsay Elliott 

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    UserDAO dao = new UserDAO();
    MedScheduleDAO medSchedDao = new MedScheduleDAO();
    MedicationDAO medDAO = new MedicationDAO();

    @RequestMapping(method = RequestMethod.GET,
                    headers="Accept=*/*",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody JSONObject displayDashboard(int uid) {
        JSONObject dashboard = new JSONObject();

        User user = dao.findById(uid);
        dashboard.put("name", user.getFirstName() + user.getLastName());
        dashboard.put("userType", user.getUserType());
        dashboard.put("medalsEarned", user.getMedals());
        dashboard.put("medalStreak", user.getStreak());

        LocalDate today = LocalDate.now();
        LocalTime todayTime = LocalTime.now();

        int dayOfWeekNum = today.getDayOfWeek().getValue(); //Monday=1
        int nowTime = Integer.parseInt(todayTime.getHour() + "" +  todayTime.getMinute() + "" + todayTime.getSecond());

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

        //missedMedications is hardcoded
        List<JSONObject> unmarked = new ArrayList<JSONObject>();

        JSONObject unmarkedItem = new JSONObject();
        unmarkedItem.put("pillName", "Advil");
        unmarkedItem.put("pillID", 1);
        unmarkedItem.put("pillDosage", 1000);
        unmarkedItem.put("pillDate", "Nov. 19th @ 4:00 PM");

        unmarked.add(unmarkedItem);

        dashboard.put("unmarkedPills", unmarked);

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
