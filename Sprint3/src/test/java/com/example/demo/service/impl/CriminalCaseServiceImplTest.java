package com.example.demo.service.impl;

import com.example.demo.core.CaseStatus;
import com.example.demo.core.CaseType;
import com.example.demo.model.Detective;
import com.example.demo.repo.jdpctemplate.JdbcDetectiveRepo;
import com.example.demo.service.CriminalCaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CriminalCaseServiceImplTest {
@Autowired
private CriminalCaseService criminalCaseService;
private JdbcDetectiveRepo jdbcDetectiveRepo;
    @Test
    void findByLeadInvestigator() {
        Optional<Detective> detective= jdbcDetectiveRepo.findById(1L);
        assertEquals(2,criminalCaseService.findByLeadInvestigator(detective.get()).size());
    }

    @Test
    void findByNumber() {
        assertEquals("1", criminalCaseService.findByNumber("1").get().getNumber());
    }

    @Test
    void findByStatus() {
        assertEquals(2, criminalCaseService.findByStatus(CaseStatus.SUBMITTED).size());
    }

    @Test
    void findByType() {
        assertEquals(1,criminalCaseService.findByType(CaseType.UNCATEGORIZED).size());
    }

    @Test
    void testFindByLeadInvestigator() {
        Optional<Detective> detective= jdbcDetectiveRepo.findById(1L);
        assertEquals(1, criminalCaseService.findByLeadInvestigator(detective.get()).size());
    }

    @Test
    void testFindByNumber() {
        assertEquals(1, criminalCaseService.findByNumber("1").get().getNumber());
    }

    @Test
    void testFindByStatus() {
        assertEquals(2,criminalCaseService.findByStatus(CaseStatus.SUBMITTED));
    }

    @Test
    void testFindByType() {
        assertEquals(0,criminalCaseService.findByType(CaseType.UNCATEGORIZED).size());
    }
}