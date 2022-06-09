package com.fis.cems.dao.mem;

import com.fis.cems.model.CriminalCase;
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

        CriminalCase criminalCase2 = new CriminalCase();
        criminalCase2.setId(2L);
        criminalCase2.setNumber("CS002");
        criminalCase2.setType(CaseType.UNCATEGORIZED);

        CriminalCase criminalCase3 = new CriminalCase();
        criminalCase3.setId(3L);
        criminalCase3.setNumber("CS003");
        criminalCase3.setType(CaseType.UNCATEGORIZED);


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
    void save() {
    }

    @Test
    void count() {
    }

    @Test
    void delete() {
    }

    @Test
    void existsById() {
    }

    @AfterEach
     void closeDatabase() {
        database.clear();
    }

}