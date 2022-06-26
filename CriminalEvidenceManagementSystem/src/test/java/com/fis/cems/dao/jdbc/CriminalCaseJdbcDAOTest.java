package com.fis.cems.dao.jdbc;

import com.fis.cems.model.CriminalCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class CriminalCaseJdbcDAOTest {
    private static CriminalCaseJdbcDAO criminalCaseJdbcDAO = null;
    private static final Logger LOGGER = LoggerFactory.getLogger(CriminalCaseJdbcDAOTest.class);
    @BeforeAll
    static void init() {
        criminalCaseJdbcDAO = new CriminalCaseJdbcDAO();
    }

    @Test
    void findAll() {
        List<CriminalCase> criminalCases = criminalCaseJdbcDAO.findAll();
        criminalCases.forEach(System.out::println);
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
        long count = criminalCaseJdbcDAO.count();
        assertEquals(3, count);
    }

    @Test
    void delete() {
        Long id = 2L;
        criminalCaseJdbcDAO.delete(id);
    }

    @Test
    void existsById() {
    }
}