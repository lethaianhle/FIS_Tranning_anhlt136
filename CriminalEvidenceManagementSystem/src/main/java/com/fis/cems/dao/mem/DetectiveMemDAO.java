package com.fis.cems.dao.mem;

import com.fis.cems.dao.IDetectiveDAO;
import com.fis.cems.model.Detective;

import java.util.List;
import java.util.Optional;

public class DetectiveMemDAO implements IDetectiveDAO {
    @Override
    public List<Detective> findAll() {
        return null;
    }

    @Override
    public Optional<Detective> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Detective save(Detective entity) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Detective entity) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
