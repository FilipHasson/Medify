package com.best.superteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pendingLinks")
public class PendingLinksController {
    @RequestMapping(method = RequestMethod.GET)
    public String displayRequestPage()
    {
        return "pendingLinks";
    }
}
