package com.fis.cems.dao;

import com.fis.cems.model.CriminalCase;

import java.util.List;
import java.util.Optional;

public interface ICriminalCaseDAO {
    List<CriminalCase> findAll();

    Optional<CriminalCase> findById(Long id);

    CriminalCase save(CriminalCase criminalCase);

    long count();

    void delete(Long id);

    boolean existsById(Long id);
}
