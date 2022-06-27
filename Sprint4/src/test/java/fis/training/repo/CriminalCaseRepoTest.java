package fis.training.repo;

import fis.training.entity.CriminalCase;
import fis.training.entity.Detective;
import fis.training.enums.CaseStatus;
import fis.training.enums.CaseType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class CriminalCaseRepoTest {

    @Autowired
    private CriminalCaseRepo criminalCaseRepo;

    @Autowired
    private DetectiveRepo detectiveRepo;

    @Test
    void findAll() {
        List<CriminalCase> criminalCaseList = criminalCaseRepo.findAll();
        criminalCaseList.forEach(criminalCase -> log.info(criminalCase.toString()));
        assertThat(3).isEqualTo(criminalCaseList.size());
    }

    @Test
    void findByIdExisted() {
        Long id = 3L;

        CriminalCase criminalCase = criminalCaseRepo.findById(id).orElse(null);
        log.info(criminalCase.toString());

        assertThat(criminalCase).isNotNull();
    }

    @Test
    void create() {
        CriminalCase criminalCaseTemp = new CriminalCase();
        criminalCaseTemp.setCreatedAt(LocalDateTime.now());
        criminalCaseTemp.setModifiedAt(LocalDateTime.now());
        criminalCaseTemp.setVersion(1);
        criminalCaseTemp.setDetailedDescription("DetailedDescTest");
        criminalCaseTemp.setNotes("NotesTest");
        criminalCaseTemp.setNumber("NUMBER_TEST");
        criminalCaseTemp.setShortDescription("ShortDescTest");
        criminalCaseTemp.setStatus(CaseStatus.COLD);
        criminalCaseTemp.setType(CaseType.UNCATEGORIZED);

        Detective detective = detectiveRepo.findById(1L).orElse(null);

        criminalCaseTemp.setLeadInvestigator(detective);
        CriminalCase criminalCase = criminalCaseRepo.save(criminalCaseTemp);

        assertThat(criminalCase).isNotNull();
    }

    @Test
    void update() {
        CriminalCase criminalCaseTemp = criminalCaseRepo.findById(1L).orElse(null);
        assert criminalCaseTemp != null;
        criminalCaseTemp.setModifiedAt(LocalDateTime.now());
        criminalCaseTemp.setVersion(2);
        criminalCaseTemp.setDetailedDescription("DetailedDescTestUpdate");

        criminalCaseRepo.save(criminalCaseTemp);

        CriminalCase criminalCaseAfterUpdated = criminalCaseRepo.findById(1L).orElse(null);

        assert criminalCaseAfterUpdated != null;
        assertThat(criminalCaseAfterUpdated.getDetailedDescription()).isEqualTo(criminalCaseTemp.getDetailedDescription());
    }

    @Test
    void delete() {
        Long id = 2L;
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(id);
        criminalCaseRepo.delete(criminalCase);

        CriminalCase criminalCaseAfterDeleted = criminalCaseRepo.findById(id).orElse(null);

        assertThat(criminalCaseAfterDeleted).isNull();
    }

}