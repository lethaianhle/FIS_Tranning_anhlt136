package com.fis.cems.dao;

import com.fis.cems.model.CriminalCase;

public interface ICriminalCaseDAO {
    CriminalCase findById(Long id);
}
