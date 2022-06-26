package com.example.demo.service.impl;

import com.example.demo.model.enums.CaseStatus;
import com.example.demo.model.enums.CaseType;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.CriminalCase;
import com.example.demo.model.Detective;
import com.example.demo.repository.jpa.CriminalCaseRepo;
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
    public void create(CriminalCase criminalCase) {
        criminalCaseRepo.save(criminalCase);
    }

    @Override
    public List<CriminalCase> getAll() {
        return criminalCaseRepo.findAll();
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {
        return criminalCaseRepo.save(criminalCase);
    }

    @Override
    public void deleteById(Long id) {
        criminalCaseRepo.deleteById(id);
    }

    @Override
    public CriminalCase findById(Long id) {
        return criminalCaseRepo.findById(id).orElse(null);
    }

    @Override
    public List<CriminalCase> findByUsername(String username) {
        return null;
    }

    @Override
    public List<CriminalCase> findByStatus(CaseStatus status) {
        List<CriminalCase> criminalCaseList= criminalCaseRepo.findAll().stream().
                filter(c->status.equals(c.getStatus())).collect(Collectors.toList());

        return criminalCaseList;
    }

}
