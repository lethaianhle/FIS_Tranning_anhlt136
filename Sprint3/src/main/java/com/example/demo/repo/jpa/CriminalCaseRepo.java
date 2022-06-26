package com.example.demo.repo.jpa;


import com.example.demo.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CriminalCaseRepo extends JpaRepository<CriminalCase,Long> {
//    Set<CriminalCase> findByLeadInvestigator(Detective detective);
//    Optional<CriminalCase> findByNumber(String caseNumber);
//    Set<CriminalCase> findByStatus(CaseStatus status);
//    Set<CriminalCase> findByType(CaseType type);
}
