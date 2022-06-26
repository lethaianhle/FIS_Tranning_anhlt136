package com.example.demo.service;



import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;


public interface PersonService {
    Optional<Person> findByUsername(String username);

    List<Person> findAll();

    long count();

     Person save(Person person);

}
