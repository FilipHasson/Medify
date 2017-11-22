package com.best.superteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/searchLinks")
public class SearchLinksController {
    @RequestMapping(method = RequestMethod.GET)
    public String displayRequestPage()
    {
        return "searchLinks";
    }
}
