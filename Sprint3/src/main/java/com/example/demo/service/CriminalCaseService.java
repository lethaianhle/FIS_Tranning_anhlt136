package com.example.demo.service;



import com.example.demo.core.CaseStatus;
import com.example.demo.core.CaseType;
import com.example.demo.model.CriminalCase;
import com.example.demo.model.Detective;

import java.util.List;
import java.util.Optional;

public interface CriminalCaseService {
    List<CriminalCase> findByLeadInvestigator(Detective detective);
    Optional<CriminalCase> findByNumber(String caseNumber);
    List<CriminalCase> findByStatus(CaseStatus status);
    List<CriminalCase> findByType(CaseType type);
}
