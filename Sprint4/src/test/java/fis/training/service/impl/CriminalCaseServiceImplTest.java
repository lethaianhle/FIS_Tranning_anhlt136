package fis.training.service.impl;

import fis.training.dto.CriminalCaseDTO;
import fis.training.entity.CriminalCase;
import fis.training.entity.Detective;
import fis.training.enums.CaseStatus;
import fis.training.enums.CaseType;
import fis.training.repo.DetectiveRepo;
import fis.training.service.CriminalCaseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CriminalCaseServiceImplTest {

    @Autowired
    private CriminalCaseService criminalCaseService;

    @Autowired
    private DetectiveRepo detectiveRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    void findByStatus() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void createEntityByDTO() {
        CriminalCaseDTO criminalCaseDTO = new CriminalCaseDTO();
        criminalCaseDTO.setNumber("UUUU");
        criminalCaseDTO.setType(CaseType.UNCATEGORIZED);
        criminalCaseDTO.setShortDescription("ss");
        criminalCaseDTO.setDetailedDescription("dd");
        criminalCaseDTO.setStatus(CaseStatus.IN_COURT);
        criminalCaseDTO.setNotes("tt");
        criminalCaseDTO.setEvidenceSet(new HashSet<>());

        Detective detective = detectiveRepo.findById(1L).orElse(null);
        criminalCaseDTO.setLeadInvestigator(detective);

        criminalCaseDTO.setAssigned(new HashSet<>());

        CriminalCase result = criminalCaseService.createEntityByDTO(criminalCaseDTO);
        assertNotNull(result);
        log.info("----------- " + result);
    }

    @Test
    void updateEntityByDTO() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }
}