package com.example.demo.service;



import com.example.demo.model.enums.CaseStatus;
import com.example.demo.model.enums.CaseType;
import com.example.demo.model.CriminalCase;
import com.example.demo.model.Detective;

import java.util.List;
import java.util.Optional;

public interface CriminalCaseService {

    void create(CriminalCase criminalCase);

    List<CriminalCase> getAll();

    CriminalCase update(CriminalCase criminalCase);

    void deleteById(Long id);

    CriminalCase findById(Long id);

    List<CriminalCase> findByUsername(String username);

    List<CriminalCase> findByStatus(CaseStatus status);


}
