package com.best.superteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/success")
public class SuccessController {
    @RequestMapping(method = RequestMethod.GET)
    public String displayRequestPage()
    {
        return "success";
    }
}
