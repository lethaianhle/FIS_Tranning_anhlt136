
package com.fis.cems.dao.mem;

import com.fis.cems.dao.IDetectiveDAO;
import com.fis.cems.model.Detective;
import com.fis.cems.util.MemoryStorageUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DetectiveMemDAO implements IDetectiveDAO {

    private static Map<Long, Detective> database = MemoryStorageUtil.getDetectives();
    @Override
    public List<Detective> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<Detective> findById(Long id) {
        if (id == null || id < 0) return Optional.empty();

        return Optional.of(database.get(id));
    }

    @Override
    public Detective save(Detective detective) {
        if (detective.getId() < 0) return null;

        if (detective.getId() == null) {
            detective.setId(database.size() + 1L);
        }

        database.put(detective.getId(), detective);

        return database.get(detective.getId());
    }

    @Override
    public long count() {
        return database.size();
    }

    @Override
    public void delete(Detective detective) {
        if (detective.getId() == null || detective.getId() < 0) return;

        database.remove(detective.getId(), detective);
    }

    @Override
    public boolean existsById(Long id) {
        return database.containsKey(id);
    }
}
