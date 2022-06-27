package fis.training.repo;

import fis.training.entity.Detective;
import fis.training.entity.Evidence;
import fis.training.entity.Person;
import fis.training.enums.EmploymentStatus;
import fis.training.enums.Rank;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class EvidenceRepoTest {

    @Autowired
    private EvidenceRepo evidenceRepo;

    @Autowired
    private CriminalCaseRepo criminalCaseRepo;

    @Autowired
    private StorageRepo storageRepo;

    @Test
    void findAll() {
        List<Evidence> evidences = evidenceRepo.findAll();
        evidences.forEach(evidence -> log.info(evidence.toString()));
        assertThat(3).isEqualTo(evidences.size());
    }

    @Test
    void findByIdExisted() {
        Long id = 3L;

        Evidence evidence = evidenceRepo.findById(id).orElse(null);
        log.info(evidence.toString());

        assertThat(evidence).isNotNull();
    }

    @Test
    void create() {

    }

    @Test
    void update() {

    }

    @Test
    void delete() {
        Long id = 2L;
        Evidence evidence = evidenceRepo.findById(id).orElse(null);
        evidenceRepo.delete(evidence);

        Evidence evidenceAfterDeleted = evidenceRepo.findById(id).orElse(null);

        assertThat(evidenceAfterDeleted).isNull();
    }

}