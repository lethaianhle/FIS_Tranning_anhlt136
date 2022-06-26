package com.fis.cems.dao.jdbc;

import com.fis.cems.dao.IDetectiveDAO;
import com.fis.cems.mapper.CriminalCaseMapper;
import com.fis.cems.mapper.DetectiveMapper;
import com.fis.cems.model.CriminalCase;
import com.fis.cems.model.Detective;

import java.util.List;
import java.util.Optional;

public class DetectiveJdbcDAO extends AbstractDAO<Detective> implements IDetectiveDAO {

    @Override
    public List<Detective> findAll() {
        String sql = "SELECT * FROM detective";
        return super.query(sql, new DetectiveMapper());
    }

    @Override
    public Optional<Detective> findById(Long id) {
        String sql = "SELECT * FROM detective WHERE id = ?";
        List<Detective> list = super.query(sql, new DetectiveMapper(), id);
        Detective detective = list.get(0);

        return Optional.of(detective);
    }

    @Override
    public Detective save(Detective detective) {
        return null;
    }

    @Override
    public long count() {
        String sql = "SELECT COUNT(*) FROM detective";
        return count(sql);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM detective WHERE id = ?";
        update(sql, id);
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
