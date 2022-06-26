package fis_training.service.impl;

import fis_training.enums.CaseStatus;
import fis_training.entity.CriminalCase;
import fis_training.exception.ParamInvalidException;
import fis_training.repo.CriminalCaseRepo;
import fis_training.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CriminalCaseServiceImpl implements CriminalCaseService {

    private final CriminalCaseRepo criminalCaseRepo;

    @Autowired
    public CriminalCaseServiceImpl(CriminalCaseRepo criminalCaseRepo) {
        this.criminalCaseRepo = criminalCaseRepo;
    }

    @Override
    public List<CriminalCase> findByStatus(CaseStatus status) {
        return criminalCaseRepo.findAll().stream()
                .filter(c->status.equals(c.getStatus()))
                .collect(Collectors.toList());
    }


    @Override
    public CriminalCase create(CriminalCase criminalCase) {
        if (criminalCase == null) throw new ParamInvalidException();

        return criminalCaseRepo.save(criminalCase);
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {
        if (criminalCase == null) throw new ParamInvalidException();

        return criminalCaseRepo.save(criminalCase);
    }

    @Override
    public void delete(CriminalCase criminalCase) {
        criminalCaseRepo.delete(criminalCase);
    }

    @Override
    public void deleteById(Long id) {
        criminalCaseRepo.deleteById(id);
    }

    @Override
    public Optional<CriminalCase> findById(Long id) {
        return criminalCaseRepo.findById(id);
    }

    @Override
    public List<CriminalCase> findAll() {
        return criminalCaseRepo.findAll();
    }
}
