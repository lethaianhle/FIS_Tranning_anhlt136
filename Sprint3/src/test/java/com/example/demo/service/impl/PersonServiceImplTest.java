package com.example.demo.service.impl;

import com.example.demo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonServiceImplTest {
    @Autowired
    private PersonService personService;

    @Test
    void findByUsername() {
        assertEquals("tt", personService.findByUsername("tt").get().getUsername());
    }


    @Test
    void findAll() {
        assertEquals(1,personService.findAll().size());
    }


    @Test
    void count() {
    assertEquals(1,personService.count());
    }

    @Test
    void testFindByUsername() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void testCount() {
    }

    @Test
    void save() {
    }
}