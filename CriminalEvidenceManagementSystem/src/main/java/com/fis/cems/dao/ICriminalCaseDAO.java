package com.fis.cems.dao;

import com.fis.cems.model.CriminalCase;
import com.fis.cems.model.enums.CaseType;

import java.util.List;

public interface ICriminalCaseDAO extends GenericDAO<CriminalCase> {
    List<CriminalCase> findByCaseType(CaseType caseType);

}
