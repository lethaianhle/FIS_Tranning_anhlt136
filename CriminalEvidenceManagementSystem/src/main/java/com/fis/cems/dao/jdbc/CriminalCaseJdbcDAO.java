package com.fis.cems.dao.jdbc;

import com.fis.cems.dao.ICriminalCaseDAO;
import com.fis.cems.model.CriminalCase;

public class CriminalCaseJdbcDAO extends AbstractDAO<CriminalCase> implements ICriminalCaseDAO {
    @Override
    public CriminalCase findById(Long id) {
        return null;
    }
}
