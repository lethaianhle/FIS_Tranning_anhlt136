package com.fis.cems.dao.mem;

import com.fis.cems.dao.IEvidenceDAO;
import com.fis.cems.exception.DetectiveNotFoundException;
import com.fis.cems.exception.EvidenceNotFoundException;
import com.fis.cems.exception.InvalidParamException;
import com.fis.cems.model.Evidence;
import com.fis.cems.util.MemoryStorageUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EvidenceMemDAO implements IEvidenceDAO {

    private Map<Long, Evidence> database = MemoryStorageUtil.getEvidences();

    @Override
    public List<Evidence> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public Optional<Evidence> findById(Long id) {
        if (id == null || id < 0) return Optional.empty();

        return Optional.of(database.get(id));
    }

    @Override
    public Evidence save(Evidence evidence) {
        if (evidence.getId() == null)
            evidence.setId(database.size() + 1L);

        if (evidence.getId() < 0)
            throw new InvalidParamException("Invalid evidence with id: " + evidence.getId());

        if (database.containsKey(evidence.getId()))
            evidence.setId(database.size() + 1L);

        database.put(evidence.getId(), evidence);

        return database.get(evidence.getId());
    }

    @Override
    public long count() {
        return database.size();
    }

    @Override
    public void delete(Evidence evidence) {
        if (evidence.getId() == null || evidence.getId() <= 0)
            throw new InvalidParamException("Invalid evidence with id: " + evidence.getId());

        if (findById(evidence.getId()).isEmpty())
            throw new EvidenceNotFoundException("Evidence with id: " + evidence.getId() + " not found!");

        database.remove(evidence.getId(), evidence);
    }

    @Override
    public boolean existsById(Long id) {
        return database.containsKey(id);
    }

    @Override
    public List<Evidence> findByCriminalNumberOnlyForSenior(String number) {
        return findAll().stream().filter(evidence -> evidence.getCriminalCase().getNumber().equals(number)).toList();
    }
}
