package com.howard.gank_sc_hystrix.service;

import com.howard.gank_sc_common.module.Person;
import com.howard.gank_sc_hystrix.config.ServerConfig;
import com.howard.gank_sc_hystrix.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ServerConfig serverConfig;

    public Person getPersonByName(String id) {
        Optional<Person> person = personRepository.findById(id);
        Person person1 = new Person("1", "admin1", 10, "gank", "engineer", "none");
        person1.setComment(serverConfig.comment);
        return person.orElse(person1);
    }
}
