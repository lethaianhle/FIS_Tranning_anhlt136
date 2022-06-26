package fis_training.repo;


import fis_training.entity.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CriminalCaseRepo extends JpaRepository<CriminalCase,Long> {

}
