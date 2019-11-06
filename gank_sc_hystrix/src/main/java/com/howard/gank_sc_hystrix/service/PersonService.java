package com.howard.gank_sc_hystrix.service;

import com.howard.gank_sc_common.module.Person;
import com.howard.gank_sc_hystrix.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPersonByName(String id){
        return personRepository.findById(id).get();
    }
}
