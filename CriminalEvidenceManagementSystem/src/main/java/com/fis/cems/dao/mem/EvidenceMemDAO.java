package com.fis.cems.dao.mem;

import com.fis.cems.dao.IEvidenceDAO;
import com.fis.cems.model.Evidence;

import java.util.List;
import java.util.Optional;

public class EvidenceMemDAO implements IEvidenceDAO {
    @Override
    public List<Evidence> findAll() {
        return null;
    }

    @Override
    public Optional<Evidence> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Evidence save(Evidence entity) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Evidence entity) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
