package fis.training;

import fis.training.entity.*;
import fis.training.enums.*;
import fis.training.repo.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
class Sprint4ApplicationTests {

	@Autowired
	private DetectiveRepo detectiveRepo;

	@Autowired
	private PersonRepo personRepo;

	@Autowired
	private StorageRepo storageRepo;

	@Autowired
	private CriminalCaseRepo criminalCaseRepo;

	@Autowired
	private EvidenceRepo evidenceRepo;

	@Autowired
	private TrackEntryRepo trackEntryRepo;

	@Test
	void initSchema() {
		log.info("Database Schema Init ---------------------");
	}

	@Test
	void initData() {
		Storage storage1 = new Storage();
		storage1.setCreatedAt(LocalDateTime.now());
		storage1.setModifiedAt(LocalDateTime.now());
		storage1.setVersion(1);
		storage1.setLocation("Location Testing1");
		storage1.setName("LocationName1");
		storageRepo.save(storage1);

		Storage storage2 = new Storage();
		storage2.setCreatedAt(LocalDateTime.now());
		storage2.setModifiedAt(LocalDateTime.now());
		storage2.setVersion(1);
		storage2.setLocation("Location Testing2");
		storage2.setName("LocationName2");
		storageRepo.save(storage2);

		Storage storage3 = new Storage();
		storage3.setCreatedAt(LocalDateTime.now());
		storage3.setModifiedAt(LocalDateTime.now());
		storage3.setVersion(1);
		storage3.setLocation("Location Testing3");
		storage3.setName("LocationName3");
		storageRepo.save(storage3);


		Person person1 = new Person();
		person1.setCreatedAt(LocalDateTime.now());
		person1.setModifiedAt(LocalDateTime.now());
		person1.setVersion(1);
		person1.setFirstName("PersonFirstName1");
		person1.setHiringDate(LocalDateTime.now());
		person1.setLastName("PersonLastName1");
		person1.setPassword("123");
		person1.setUsername("person1");
		personRepo.save(person1);

		Person person2 = new Person();
		person2.setCreatedAt(LocalDateTime.now());
		person2.setModifiedAt(LocalDateTime.now());
		person2.setVersion(1);
		person2.setFirstName("PersonFirstName2");
		person2.setHiringDate(LocalDateTime.now());
		person2.setLastName("PersonLastName2");
		person2.setPassword("123");
		person2.setUsername("person2");
		personRepo.save(person2);

		Person person3 = new Person();
		person3.setCreatedAt(LocalDateTime.now());
		person3.setModifiedAt(LocalDateTime.now());
		person3.setVersion(1);
		person3.setFirstName("PersonFirstName3");
		person3.setHiringDate(LocalDateTime.now());
		person3.setLastName("PersonLastName3");
		person3.setPassword("123");
		person3.setUsername("person3");
		personRepo.save(person3);

		Detective detective1 = new Detective();
		detective1.setCreatedAt(LocalDateTime.now());
		detective1.setModifiedAt(LocalDateTime.now());
		detective1.setVersion(1);
		detective1.setArmed(false);
		detective1.setBadgeNumber("BND1");
		detective1.setRank(Rank.JUNIOR);
		detective1.setStatus(EmploymentStatus.RETIRED);
		detective1.setPerson(person1);
		detectiveRepo.save(detective1);

		Detective detective2 = new Detective();
		detective2.setCreatedAt(LocalDateTime.now());
		detective2.setModifiedAt(LocalDateTime.now());
		detective2.setVersion(1);
		detective2.setArmed(false);
		detective2.setBadgeNumber("BND2");
		detective2.setRank(Rank.CHIEF_INSPECTOR);
		detective2.setStatus(EmploymentStatus.ACTIVE);
		detective2.setPerson(person2);
		detectiveRepo.save(detective2);

		Detective detective3 = new Detective();
		detective3.setCreatedAt(LocalDateTime.now());
		detective3.setModifiedAt(LocalDateTime.now());
		detective3.setVersion(1);
		detective3.setArmed(false);
		detective3.setBadgeNumber("BND3");
		detective3.setRank(Rank.SENIOR);
		detective3.setStatus(EmploymentStatus.UNDER_INVESTIGATION);
		detective3.setPerson(person3);
		detectiveRepo.save(detective3);

		CriminalCase criminalCase1 = new CriminalCase();
		criminalCase1.setCreatedAt(LocalDateTime.now());
		criminalCase1.setModifiedAt(LocalDateTime.now());
		criminalCase1.setVersion(1);
		criminalCase1.setDetailedDescription("DetailedDesc1");
		criminalCase1.setNotes("Notes1");
		criminalCase1.setNumber("NUMBER1");
		criminalCase1.setShortDescription("ShortDesc1");
		criminalCase1.setStatus(CaseStatus.COLD);
		criminalCase1.setType(CaseType.UNCATEGORIZED);
		criminalCase1.setLeadInvestigator(detective1);
		criminalCaseRepo.save(criminalCase1);

		CriminalCase criminalCase2 = new CriminalCase();
		criminalCase2.setCreatedAt(LocalDateTime.now());
		criminalCase2.setModifiedAt(LocalDateTime.now());
		criminalCase2.setVersion(1);
		criminalCase2.setDetailedDescription("DetailedDesc2");
		criminalCase2.setNotes("Notes2");
		criminalCase2.setNumber("NUMBER2");
		criminalCase2.setShortDescription("ShortDesc2");
		criminalCase2.setStatus(CaseStatus.DISMISSED);
		criminalCase2.setType(CaseType.INFRACTION);
		criminalCase2.setLeadInvestigator(detective1);
		criminalCaseRepo.save(criminalCase2);

		CriminalCase criminalCase3 = new CriminalCase();
		criminalCase3.setCreatedAt(LocalDateTime.now());
		criminalCase3.setModifiedAt(LocalDateTime.now());
		criminalCase3.setVersion(1);
		criminalCase3.setDetailedDescription("DetailedDesc3");
		criminalCase3.setNotes("Notes3");
		criminalCase3.setNumber("NUMBER3");
		criminalCase3.setShortDescription("ShortDesc3");
		criminalCase3.setStatus(CaseStatus.IN_COURT);
		criminalCase3.setType(CaseType.MISDEMEANOR);
		criminalCase3.setLeadInvestigator(detective2);
		criminalCaseRepo.save(criminalCase3);

		Evidence evidence1 = new Evidence();
		evidence1.setCreatedAt(LocalDateTime.now());
		evidence1.setModifiedAt(LocalDateTime.now());
		evidence1.setVersion(1);
		evidence1.setArchived(false);
		evidence1.setItemName("ItemName1");
		evidence1.setNotes("Notes1");
		evidence1.setNumber("NUMBER1");
		evidence1.setCriminalCase(criminalCase1);
		evidence1.setStorage(storage1);
		evidenceRepo.save(evidence1);

		Evidence evidence2 = new Evidence();
		evidence2.setCreatedAt(LocalDateTime.now());
		evidence2.setModifiedAt(LocalDateTime.now());
		evidence2.setVersion(1);
		evidence2.setArchived(false);
		evidence2.setItemName("ItemName2");
		evidence2.setNotes("Notes2");
		evidence2.setNumber("NUMBER2");
		evidence2.setCriminalCase(criminalCase1);
		evidence2.setStorage(storage1);
		evidenceRepo.save(evidence2);

		Evidence evidence3 = new Evidence();
		evidence3.setCreatedAt(LocalDateTime.now());
		evidence3.setModifiedAt(LocalDateTime.now());
		evidence3.setVersion(1);
		evidence3.setArchived(false);
		evidence3.setItemName("ItemName3");
		evidence3.setNotes("Notes3");
		evidence3.setNumber("NUMBER3");
		evidence3.setCriminalCase(criminalCase2);
		evidence3.setStorage(storage3);
		evidenceRepo.save(evidence3);

		TrackEntry trackEntry1 = new TrackEntry();
		trackEntry1.setCreatedAt(LocalDateTime.now());
		trackEntry1.setModifiedAt(LocalDateTime.now());
		trackEntry1.setVersion(1);
		trackEntry1.setAction(TrackAction.RETRIEVED);
		trackEntry1.setDate(LocalDateTime.now());
		trackEntry1.setDetective(detective1);
		trackEntry1.setEvidence(evidence1);
		trackEntryRepo.save(trackEntry1);

		TrackEntry trackEntry2 = new TrackEntry();
		trackEntry2.setCreatedAt(LocalDateTime.now());
		trackEntry2.setModifiedAt(LocalDateTime.now());
		trackEntry2.setVersion(1);
		trackEntry2.setAction(TrackAction.RETRIEVED);
		trackEntry2.setDate(LocalDateTime.now());
		trackEntry2.setDetective(detective1);
		trackEntry2.setEvidence(evidence3);
		trackEntryRepo.save(trackEntry2);

		TrackEntry trackEntry3 = new TrackEntry();
		trackEntry3.setCreatedAt(LocalDateTime.now());
		trackEntry3.setModifiedAt(LocalDateTime.now());
		trackEntry3.setVersion(1);
		trackEntry3.setAction(TrackAction.RETRIEVED);
		trackEntry3.setDate(LocalDateTime.now());
		trackEntry3.setDetective(detective2);
		trackEntry3.setEvidence(evidence1);
		trackEntryRepo.save(trackEntry3);
	}

	@Test
	void contextLoads() {
	}

}
