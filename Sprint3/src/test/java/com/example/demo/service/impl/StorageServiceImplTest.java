package com.example.demo.service.impl;

import com.example.demo.service.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StorageServiceImplTest {
@Autowired
private StorageService storageService;
    @Test
    void findByName() {
        assertEquals("DongDo",storageService.findByName("DongDo").get().getName());
    }

    @Test
    void findByLocation() {
        assertEquals("HN",storageService.findByName("HN").get().getName());
    }
}