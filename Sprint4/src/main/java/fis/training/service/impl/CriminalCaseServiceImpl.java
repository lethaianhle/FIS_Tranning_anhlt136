package fis.training.service.impl;

import fis.training.dto.CriminalCaseDTO;
import fis.training.enums.CaseStatus;
import fis.training.enums.ResultEnums;
import fis.training.exception.ItemNotFoundException;
import fis.training.exception.ParamInvalidException;
import fis.training.repo.CriminalCaseRepo;
import fis.training.entity.CriminalCase;
import fis.training.service.CriminalCaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CriminalCaseServiceImpl implements CriminalCaseService {

    private final CriminalCaseRepo criminalCaseRepo;

    private final ModelMapper modelMapper;

    public CriminalCaseServiceImpl(CriminalCaseRepo criminalCaseRepo, ModelMapper modelMapper) {
        this.criminalCaseRepo = criminalCaseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CriminalCase> findByStatus(CaseStatus status) {
        return criminalCaseRepo.findAll().stream()
                .filter(c->status.equals(c.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CriminalCase> findByUsername(String username) {
        return null;
    }

    @Override
    public CriminalCase createEntityByDTO(CriminalCaseDTO criminalCaseDTO) {
        CriminalCase criminalCase = modelMapper.map(criminalCaseDTO, CriminalCase.class);

        if (criminalCase == null) throw new ParamInvalidException();

        criminalCase.setVersion(1);
        criminalCase.setCreatedAt(LocalDateTime.now());
        criminalCase.setModifiedAt(null);

        return criminalCaseRepo.save(criminalCase);
    }

    @Override
    public CriminalCase updateEntityByDTO(Long id, CriminalCaseDTO criminalCaseDTO) {
        Optional<CriminalCase> criminalCase = criminalCaseRepo.findById(id);

        if (criminalCase.isEmpty()) throw new ItemNotFoundException(ResultEnums.ITEM_NOT_FOUND_ERROR.getMessage());

        CriminalCase requestCase = modelMapper.map(criminalCaseDTO, CriminalCase.class);
        requestCase.setId(criminalCase.get().getId());
        requestCase.setVersion(criminalCase.get().getVersion() + 1);
        requestCase.setCreatedAt(criminalCase.get().getCreatedAt());
        requestCase.setModifiedAt(LocalDateTime.now());

        return criminalCaseRepo.save(requestCase);
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
