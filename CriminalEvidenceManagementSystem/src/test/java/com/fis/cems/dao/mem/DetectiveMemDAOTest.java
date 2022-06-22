package com.fis.cems.dao.mem;

import com.fis.cems.model.Detective;
import com.fis.cems.model.enums.EmploymentStatus;
import com.fis.cems.model.enums.Rank;
import com.fis.cems.util.MemoryStorageUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DetectiveMemDAOTest {
    private static Map<Long, Detective> database;

    private static DetectiveMemDAO detectiveMemDAO;

    @BeforeEach
    void initDatabase() {
        database = MemoryStorageUtil.getDetectives();
        detectiveMemDAO = new DetectiveMemDAO();

        Detective detective1 = new Detective();
        detective1.setId(1L);
        detective1.setUsername("detective1");
        detective1.setFirstName("Nguyen");
        detective1.setLastName("Van Manh");
        detective1.setPassword("123");
        detective1.setHiringDate(LocalDateTime.now());
        detective1.setBadgeNumber("HL123");
        detective1.setRank(Rank.JUNIOR);
        detective1.setArmed(false);
        detective1.setStatus(EmploymentStatus.ACTIVE);
        detective1.setCriminalCases(new HashSet<>());
        detective1.setTrackEntries(new HashSet<>());

        Detective detective2 = new Detective();
        detective2.setId(2L);
        detective2.setUsername("detective2");
        detective2.setFirstName("Nguyen");
        detective2.setLastName("Van Manh");
        detective2.setPassword("123");
        detective2.setHiringDate(LocalDateTime.now());
        detective2.setBadgeNumber("HL123");
        detective2.setRank(Rank.JUNIOR);
        detective2.setArmed(false);
        detective2.setStatus(EmploymentStatus.ACTIVE);
        detective2.setCriminalCases(new HashSet<>());
        detective2.setTrackEntries(new HashSet<>());


        Detective detective3 = new Detective();
        detective3.setId(3L);
        detective3.setUsername("detective3");
        detective3.setFirstName("Le");
        detective3.setLastName("Van Manh");
        detective3.setPassword("123");
        detective3.setHiringDate(LocalDateTime.now());
        detective3.setBadgeNumber("HL123");
        detective3.setRank(Rank.JUNIOR);
        detective3.setArmed(false);
        detective3.setStatus(EmploymentStatus.ACTIVE);
        detective3.setCriminalCases(new HashSet<>());
        detective3.setTrackEntries(new HashSet<>());

        database.put(detective1.getId(), detective1);
        database.put(detective2.getId(), detective2);
        database.put(detective3.getId(), detective3);
    }

    @Test
    void findAll() {
        List<Detective> detectiveList = detectiveMemDAO.findAll();
        assertEquals(3, detectiveList.size());
    }

    @Test
    void findById() {
        Long id = 2L;
        Detective detective = detectiveMemDAO.findById(id).orElse(null);
        assertNotNull(detective);
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