package com.howard.gank_sc_hystrix.controller;

import com.howard.gank_sc_common.module.Person;
import com.howard.gank_sc_hystrix.service.PersonService;
import com.howard.gank_sc_hystrix.utils.PersonContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "person")
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") String id) {
        System.out.println("PersonController header is:"+PersonContextHolder.getContext().getUserId());

        return personService.getPersonByName(id);
    }
}
