package com.howard.gank_sc_hystrix.dao;

import com.howard.gank_sc_common.module.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
}
