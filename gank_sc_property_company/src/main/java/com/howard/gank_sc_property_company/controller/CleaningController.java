package com.howard.gank_sc_property_company.controller;

import com.howard.gank_sc_property_company.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController(value = "cleaning")
public class CleaningController {

    @Autowired
    private CleaningService cleaningService;

    @PostMapping
    public void accept(HttpServletRequest request) {
        String msg = request.getParameter("task");
        cleaningService.acceptCleaningTask(msg);
    }
}
