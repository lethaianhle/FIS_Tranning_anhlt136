package com.fis.cems.dao.mem;

import com.fis.cems.dao.ICriminalCaseDAO;
import com.fis.cems.exception.CriminalCaseNotFoundException;
import com.fis.cems.exception.InvalidParamException;
import com.fis.cems.model.CriminalCase;
import com.fis.cems.model.enums.CaseStatus;
import com.fis.cems.model.enums.CaseType;
import com.fis.cems.util.MemoryStorageUtil;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CriminalCaseMemDAO implements ICriminalCaseDAO {
    private final static Map<Long, CriminalCase> database = MemoryStorageUtil.getCriminalCases();
    @Override
    public List<CriminalCase> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public Optional<CriminalCase> findById(Long id) {
        if (id == null || id < 0) return Optional.empty();

        return Optional.ofNullable(database.get(id));
    }

    @Override
    public CriminalCase save(CriminalCase criminalCase) {

        if (criminalCase.getId() == null)
            criminalCase.setId(database.size() + 1L);

        if (criminalCase.getId() <= 0)
            throw new InvalidParamException("Invalid criminal case with id: " + criminalCase.getId());

        if (!database.containsKey(criminalCase.getId()))
            criminalCase.setId(database.size() + 1L);

        database.put(criminalCase.getId(), criminalCase);

        return database.get(criminalCase.getId());

    }

    @Override
    public long count() {
        return database.size();
    }

    @Override
    public void delete(CriminalCase criminalCase) {
        if (criminalCase.getId() == null || criminalCase.getId() <= 0)
            throw new InvalidParamException("Invalid criminal case with id: " + criminalCase.getId());

        if (findById(criminalCase.getId()).isEmpty())
            throw new CriminalCaseNotFoundException("CriminalCase with id: " + criminalCase.getId() + " not found!");

        database.remove(criminalCase.getId(), criminalCase);
    }

    @Override
    public boolean existsById(Long id) {
        return database.containsKey(id);
    }

    @Override
    public List<CriminalCase> findByCaseStatusOnlyForChiefRank(CaseStatus caseStatus) {
        return database.values()
                .stream()
                .filter(criminalCase -> criminalCase.getStatus() == caseStatus)
                .collect(Collectors.toList());
    }

}
