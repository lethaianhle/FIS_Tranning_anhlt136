package fis.training.repo;

import fis.training.entity.*;
import fis.training.enums.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class DetectiveRepoTest {

    @Autowired
    private DetectiveRepo detectiveRepo;

    @Autowired
    private PersonRepo personRepo;

    @Test
    void findAll() {
        List<Detective> detectiveList = detectiveRepo.findAll();
        detectiveList.forEach(detective -> log.info(detective.toString()));
        assertThat(detectiveList.size()).isEqualTo(3);
    }

    @Test
    void findByIdExisted() {
        Long id = 3L;

        Detective detective = detectiveRepo.findById(id).orElse(null);
        log.info(detective.toString());

        assertThat(detective).isNotNull();
    }

    @Test
    void create() {
        Detective detectiveTemp = new Detective();
        detectiveTemp.setCreatedAt(LocalDateTime.now());
        detectiveTemp.setModifiedAt(null);
        detectiveTemp.setVersion(1);
        detectiveTemp.setArmed(false);
        detectiveTemp.setBadgeNumber("BND_TEST");
        detectiveTemp.setRank(Rank.CHIEF_INSPECTOR);
        detectiveTemp.setStatus(EmploymentStatus.ACTIVE);

        Person person = personRepo.findById(1L).orElse(null);
        detectiveTemp.setPerson(person);

        Detective detective = detectiveRepo.save(detectiveTemp);

        assertThat(detective).isNotNull();
    }

    @Test
    void update() {
        Detective detectiveTemp = detectiveRepo.findById(1L).orElse(null);
        assert detectiveTemp != null;
        detectiveTemp.setModifiedAt(LocalDateTime.now());
        detectiveTemp.setVersion(2);
        detectiveTemp.setBadgeNumber("UPDATED_NUMBER");

        detectiveRepo.save(detectiveTemp);

        Detective detectiveAfterUpdated = detectiveRepo.findById(1L).orElse(null);

        assert detectiveAfterUpdated != null;
        assertThat(detectiveAfterUpdated.getBadgeNumber()).isEqualTo(detectiveTemp.getBadgeNumber());
    }

    @Test
    void delete() {
        Long id = 2L;
        Detective detective = detectiveRepo.findById(id).orElse(null);
        detectiveRepo.delete(detective);

        Detective detectiveAfterDeleted = detectiveRepo.findById(id).orElse(null);

        assertThat(detectiveAfterDeleted).isNull();
    }

}