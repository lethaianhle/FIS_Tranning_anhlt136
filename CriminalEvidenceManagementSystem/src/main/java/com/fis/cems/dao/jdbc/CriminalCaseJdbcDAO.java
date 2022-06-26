package com.fis.cems.dao.jdbc;

import com.fis.cems.dao.ICriminalCaseDAO;
import com.fis.cems.mapper.CriminalCaseMapper;
import com.fis.cems.model.CriminalCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public class CriminalCaseJdbcDAO extends AbstractDAO<CriminalCase> implements ICriminalCaseDAO {
    @Override
    public List<CriminalCase> findAll() {
        String sql = "SELECT * FROM criminal_case";
        return super.query(sql, new CriminalCaseMapper());
    }

    @Override
    public Optional<CriminalCase> findById(Long id) {
        String sql = "SELECT * FROM criminal_case WHERE id = ?";
        List<CriminalCase> list = super.query(sql, new CriminalCaseMapper(), id);
        CriminalCase criminalCase = list.get(0);

        return Optional.of(criminalCase);
    }

    @Override
    public CriminalCase save(CriminalCase criminalCase) {
        Long returnedId = null;
        StringBuilder sqlBuilder = new StringBuilder("");
        if (criminalCase.getId() == null) {
            sqlBuilder.append("INSERT INTO criminal_case")
                    .append("(number, type, short_description, detailed_description, status, notes)")
                    .append(" ")
                    .append("values(?, ?, ?, ?, ?, ?)");

            returnedId = super.create(sqlBuilder.toString(), criminalCase.getNumber(),
                                            criminalCase.getType(),
                                            criminalCase.getShortDescription(),
                                            criminalCase.getDetailedDescription(),
                                            criminalCase.getStatus(),
                                            criminalCase.getNotes());

        } else {
            sqlBuilder.append("UPDATE criminal_case")
                    .append("SET number = ?, type = ?, short_description = ?, detailed_description = ?")
                    .append(", status = ?, notes = ?")
                    .append(" WHERE id = ?");
            super.update(sqlBuilder.toString(), criminalCase.getNumber(),
                                                criminalCase.getType(),
                                                criminalCase.getShortDescription(),
                                                criminalCase.getDetailedDescription(),
                                                criminalCase.getStatus(),
                                                criminalCase.getNotes(),
                                                criminalCase.getId());

            returnedId = criminalCase.getId();
        }

        return findById(returnedId).orElse(null);
    }

    @Override
    public long count() {
        String sql = "SELECT COUNT(*) FROM criminal_case";
        return count(sql);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM criminal_case WHERE id = ?";
        update(sql, id);
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
