package com.fis.cems.dao.jdbc;

import com.fis.cems.dao.GenericDAO;
import com.fis.cems.dao.IEvidenceDAO;
import com.fis.cems.mapper.CriminalCaseMapper;
import com.fis.cems.mapper.EvidenceMapper;
import com.fis.cems.model.CriminalCase;
import com.fis.cems.model.Evidence;

import java.util.List;
import java.util.Optional;

public class EvidenceJdbcDAO extends AbstractDAO<Evidence> implements IEvidenceDAO {
    @Override
    public List<Evidence> findAll() {
        String sql = "SELECT * FROM evidence";
        return super.query(sql, new EvidenceMapper());
    }

    @Override
    public Optional<Evidence> findById(Long id) {
        String sql = "SELECT * FROM evidence WHERE id = ?";
        List<Evidence> list = super.query(sql, new EvidenceMapper(), id);
        Evidence evidence = list.get(0);

        return Optional.of(evidence);
    }

    @Override
    public Evidence save(Evidence evidence) {
        return null;
    }

    @Override
    public long count() {
        String sql = "SELECT COUNT(*) FROM evidence";
        return count(sql);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM evidence WHERE id = ?";
        update(sql, id);
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
