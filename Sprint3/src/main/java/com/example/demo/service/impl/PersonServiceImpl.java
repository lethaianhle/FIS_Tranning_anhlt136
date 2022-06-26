package com.example.demo.service.impl;


import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repository.jpa.PersonRepo;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepo personRepo;
    @Override
    public Optional<Person> findByUsername(String username){
        Optional<Person> p= personRepo.findAll().stream().filter(person -> username.equals(person.getUsername())).findFirst();
        if(!p.isPresent()) throw new NotFoundException("not found");
        return p;
    }

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }


    @Override
    public long count() {
        return personRepo.count();
    }

    @Override
    public Person save(Person person) {
        return personRepo.save(person);
    }

}
