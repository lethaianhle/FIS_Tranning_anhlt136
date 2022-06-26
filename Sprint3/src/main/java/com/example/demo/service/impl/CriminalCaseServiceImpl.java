package com.example.demo.service.impl;


import com.example.demo.core.CaseStatus;
import com.example.demo.core.CaseType;
import com.example.demo.core.NotFoundException;
import com.example.demo.model.CriminalCase;
import com.example.demo.model.Detective;
import com.example.demo.repo.jpa.CriminalCaseRepo;
import com.example.demo.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CriminalCaseServiceImpl implements CriminalCaseService {
    @Autowired
    private CriminalCaseRepo criminalCaseRepo;
    @Override
    public List<CriminalCase> findByLeadInvestigator(Detective detective) {
        List<CriminalCase> criminalCaseList= criminalCaseRepo.findAll().stream().filter(criminalCase ->
                detective.getId().equals(criminalCase.getLeadInvestigator())).collect(Collectors.toList());
        return criminalCaseList;
    }

    @Override
    public Optional<CriminalCase> findByNumber(String caseNumber) {
        Optional<CriminalCase> criminalCase= criminalCaseRepo.findAll().stream().
                                                                        filter(c->caseNumber.equals(c.getNumber())).findFirst();
        if(criminalCase.isPresent()) return criminalCase;
        throw new NotFoundException("not found");
    }

    @Override
    public List<CriminalCase> findByStatus(CaseStatus status) {
        List<CriminalCase> criminalCaseList= criminalCaseRepo.findAll().stream().
                filter(c->status.equals(c.getStatus())).collect(Collectors.toList());
        return criminalCaseList;
    }

    @Override
    public List<CriminalCase> findByType(CaseType type) {
        List<CriminalCase> criminalCaseList= criminalCaseRepo.findAll().stream().
                filter(c->type.equals(c.getType())).collect(Collectors.toList());
        return criminalCaseList;
    }
}
