package com.fis.cems.dao;

import com.fis.cems.model.CriminalCase;
import com.fis.cems.model.Detective;

import java.util.List;
import java.util.Optional;

public interface IDetectiveDAO {
    List<Detective> findAll();

    Optional<Detective> findById(Long id);

    Detective save(Detective detective);

    long count();

    void delete(Long id);

    boolean existsById(Long id);
}
