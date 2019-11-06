package com.howard.gank_sc_hystrix.controller;

import com.howard.gank_sc_common.module.Person;
import com.howard.gank_sc_hystrix.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") String id) {
        return personService.getPersonByName(id);
    }
}
