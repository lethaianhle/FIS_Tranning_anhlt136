package com.fis.cems.dao.mem;

import com.fis.cems.model.CriminalCase;
import com.fis.cems.model.enums.CaseStatus;
import com.fis.cems.model.enums.CaseType;
import com.fis.cems.util.MemoryStorageUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CriminalCaseMemDAOTest {
    private static Map<Long, CriminalCase> database;

    @BeforeEach
    void setDatabase() {
        database = MemoryStorageUtil.getCriminalCases();

        CriminalCase criminalCase1 = new CriminalCase();
        criminalCase1.setId(1L);
        criminalCase1.setNumber("CS001");
        criminalCase1.setType(CaseType.UNCATEGORIZED);
        criminalCase1.setStatus(CaseStatus.CLOSED);

        CriminalCase criminalCase2 = new CriminalCase();
        criminalCase2.setId(2L);
        criminalCase2.setNumber("CS002");
        criminalCase2.setType(CaseType.UNCATEGORIZED);
        criminalCase2.setStatus(CaseStatus.DISMISSED);

        CriminalCase criminalCase3 = new CriminalCase();
        criminalCase3.setId(3L);
        criminalCase3.setNumber("CS003");
        criminalCase3.setType(CaseType.FELONY);
        criminalCase3.setStatus(CaseStatus.DISMISSED);


        database.put(criminalCase1.getId(), criminalCase1);
        database.put(criminalCase2.getId(), criminalCase2);
        database.put(criminalCase3.getId(), criminalCase3);
    }

    @Test
    void findAll() {
        CriminalCaseMemDAO criminalCaseMemDAO = new CriminalCaseMemDAO();
        List<CriminalCase> rs = criminalCaseMemDAO.findAll();
        rs.forEach(System.out::println);

        assertEquals(3, rs.size());
    }

    @Test
    void findByIdNotExist() {
        Long id = 10L;
        CriminalCaseMemDAO criminalCaseMemDAO = new CriminalCaseMemDAO();
        Optional<CriminalCase> criminalCaseOpt = criminalCaseMemDAO.findById(id);
        CriminalCase criminalCase = criminalCaseOpt.orElse(null);

        assertNull(criminalCase);
    }

    @Test
    void findByIdNull() {
        Long id = null;
        CriminalCaseMemDAO criminalCaseMemDAO = new CriminalCaseMemDAO();
        Optional<CriminalCase> criminalCaseOptional = criminalCaseMemDAO.findById(id);
        CriminalCase criminalCase = criminalCaseOptional.orElse(null);

        assertNull(criminalCase);
    }

    @Test
    void findById() {
        Long id = 3L;
        CriminalCaseMemDAO criminalCaseMemDAO = new CriminalCaseMemDAO();
        Optional<CriminalCase> criminalCaseOptional = criminalCaseMemDAO.findById(id);
        CriminalCase criminalCase = criminalCaseOptional.orElse(null);
        System.out.println(criminalCase);

        assertNotNull(criminalCase);
    }

    @Test
    void testUpdateCriminalCase() {
        Long id = 2L;
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(id);
        criminalCase.setNumber("123");

        CriminalCaseMemDAO criminalCaseMemDAO = new CriminalCaseMemDAO();
        CriminalCase savedCC = criminalCaseMemDAO.save(criminalCase);

        assertNotNull(savedCC);
    }

    @Test
    void testCreateCriminalCase() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setNumber("123");

        CriminalCaseMemDAO criminalCaseMemDAO = new CriminalCaseMemDAO();
        CriminalCase savedCC = criminalCaseMemDAO.save(criminalCase);

        assertEquals(criminalCaseMemDAO.findAll().size(), savedCC.getId());
    }

    @Test
    void count() {
        CriminalCaseMemDAO criminalCaseMemDAO = new CriminalCaseMemDAO();
        assertEquals(3, criminalCaseMemDAO.count());
    }

    @Test
    void delete() {
        CriminalCaseMemDAO criminalCaseMemDAO = new CriminalCaseMemDAO();
        CriminalCase criminalCase2 = new CriminalCase();
        criminalCase2.setId(2L);
        criminalCase2.setNumber("CS002");
        criminalCase2.setType(CaseType.UNCATEGORIZED);
        criminalCaseMemDAO.delete(criminalCase2);

        criminalCaseMemDAO.findAll().forEach(System.out::println);
        assertEquals(2, criminalCaseMemDAO.count());
    }

    @Test
    void existsById() {

    }

    @Test
    void findByCaseStatus() {
        CriminalCaseMemDAO criminalCaseMemDAO = new CriminalCaseMemDAO();
        List<CriminalCase> criminalCases = criminalCaseMemDAO.findByCaseStatusOnlyForChiefRank(CaseStatus.DISMISSED);
        assertNotNull(criminalCases);
    }

    @AfterEach
     void closeDatabase() {
        database.clear();
    }

}