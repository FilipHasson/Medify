package com.best.superteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Filip Hasson
 */
@Controller
@RequestMapping("/editMed")
public class EditMedicationController {
    @RequestMapping(method = RequestMethod.GET)
    public String displayRequestPage()
    {
        return "editMed";
    }
}
