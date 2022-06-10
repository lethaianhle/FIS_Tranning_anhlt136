package com.fis.cems.dao.jdbc;

import com.fis.cems.model.CriminalCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CriminalCaseJdbcDAOTest {
    private CriminalCaseJdbcDAO criminalCaseJdbcDAO = null;
    @BeforeAll
    void init() {
        criminalCaseJdbcDAO = new CriminalCaseJdbcDAO();
    }

    @Test
    void findAll() {
        assertEquals(3, criminalCaseJdbcDAO.findAll().size());
    }

    @Test
    void findById() {
        Long id = 2L;
        CriminalCase criminalCase = criminalCaseJdbcDAO.findById(id).orElse(null);
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
}