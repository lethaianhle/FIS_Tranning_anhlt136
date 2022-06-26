package com.fis.cems.dao;

import com.fis.cems.model.Evidence;

import java.util.List;
import java.util.Optional;

public interface IEvidenceDAO {
    List<Evidence> findAll();

    Optional<Evidence> findById(Long id);

    Evidence save(Evidence evidence);

    long count();

    void delete(Long id);

    boolean existsById(Long id);
}
