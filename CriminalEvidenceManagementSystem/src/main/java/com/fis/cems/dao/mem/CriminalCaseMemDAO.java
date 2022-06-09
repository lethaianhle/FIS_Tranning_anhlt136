package com.fis.cems.dao.mem;

import com.fis.cems.dao.ICriminalCaseDAO;
import com.fis.cems.model.CriminalCase;
import com.fis.cems.util.MemoryStorageUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CriminalCaseMemDAO implements ICriminalCaseDAO {
    private final static Map<Long, CriminalCase> database = MemoryStorageUtil.getCriminalCases();
    @Override
    public List<CriminalCase> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<CriminalCase> findById(Long id) {
        if (id == null || id < 0) return Optional.empty();

        return Optional.ofNullable(database.get(id));
    }

    @Override
    public CriminalCase save(CriminalCase criminalCase) {

        if (criminalCase.getId() < 0) return null;

        database.put(criminalCase.getId(), criminalCase);

        return database.get(criminalCase.getId());
    }

    @Override
    public long count() {
        return database.size();
    }

    @Override
    public void delete(CriminalCase criminalCase) {
        database.remove(criminalCase.getId(), criminalCase);
    }

    @Override
    public boolean existsById(Long id) {
        return database.containsKey(id);
    }

}
