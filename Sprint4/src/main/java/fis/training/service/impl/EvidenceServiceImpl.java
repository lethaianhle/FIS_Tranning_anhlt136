package fis.training.service.impl;


import fis.training.entity.Evidence;
import fis.training.repo.EvidenceRepo;
import fis.training.service.EvidenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EvidenceServiceImpl implements EvidenceService{

    private final EvidenceRepo evidenceRepo;

    public EvidenceServiceImpl(EvidenceRepo evidenceRepo) {
        this.evidenceRepo = evidenceRepo;
    }

    @Override
    public void delete(Evidence evidence) {
        evidenceRepo.delete(evidence);
    }

    @Override
    public Evidence create(Evidence evidence) {
        return evidenceRepo.save(evidence);
    }

    @Override
    public Evidence update(Evidence evidence) {
        return evidenceRepo.save(evidence);
    }

    @Override
    public void deleteById(Long id) {
        evidenceRepo.deleteById(id);
    }

    @Override
    public Optional<Evidence> findById(Long entityId) {
        return evidenceRepo.findById(entityId);
    }

    @Override
    public List<Evidence> findAll() {
        return evidenceRepo.findAll();
    }

}
