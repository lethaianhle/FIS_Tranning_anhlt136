package com.fis.cems.dao.mem;

import com.fis.cems.dao.IEvidenceDAO;
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
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<Evidence> findById(Long id) {
        if (id == null || id < 0) return Optional.empty();

        return Optional.of(database.get(id));
    }

    @Override
    public Evidence save(Evidence evidence) {
        if (evidence.getId() < 0) return null;

        if (evidence.getId() == null) {
            evidence.setId(database.size() + 1L);
        }

        database.put(evidence.getId(), evidence);

        return database.get(evidence.getId());
    }

    @Override
    public long count() {
        return database.size();
    }

    @Override
    public void delete(Evidence evidence) {
        if (evidence.getId() == null || evidence.getId() < 0) return;

        database.remove(evidence.getId(), evidence);
    }

    @Override
    public boolean existsById(Long id) {
        return database.containsKey(id);
    }
}
