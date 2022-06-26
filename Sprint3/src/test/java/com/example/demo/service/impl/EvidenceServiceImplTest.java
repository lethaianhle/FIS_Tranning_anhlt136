package com.example.demo.service.impl;

import com.example.demo.model.CriminalCase;
import com.example.demo.model.Evidence;
import com.example.demo.model.Storage;
import com.example.demo.service.CriminalCaseService;
import com.example.demo.service.EvidenceService;
import com.example.demo.service.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EvidenceServiceImplTest {
    @Autowired
    private StorageService storageService;
    @Autowired
    private EvidenceService evidenceService;
    @Autowired
    private CriminalCaseService criminalCaseService;
    @Test
    void findByCriminalCase() {
        CriminalCase criminalCase= criminalCaseService.findByNumber("1").get();

        assertEquals(1,evidenceService.findByCriminalCase(criminalCase).size());
    }

    @Test
    void findByNumber() {
        assertEquals("1", evidenceService.findByNumber("1").get().getNumber());
    }

    @Test
    void isInStorage() {
        Storage storage= storageService.findByLocation("HN").get();
        assertFalse(evidenceService.isInStorage(storage));
    }
}