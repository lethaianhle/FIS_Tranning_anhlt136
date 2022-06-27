package fis.training.service;



import fis.training.dto.CriminalCaseDTO;
import fis.training.enums.CaseStatus;
import fis.training.entity.CriminalCase;

import java.util.List;

public interface CriminalCaseService extends AbstractService<CriminalCase> {

    List<CriminalCase> findByStatus(CaseStatus status);

    List<CriminalCase> findByUsername(String username);

    CriminalCase createEntityByDTO(CriminalCaseDTO criminalCaseDTO);

    CriminalCase updateEntityByDTO(Long id, CriminalCaseDTO criminalCaseDTO);

}
