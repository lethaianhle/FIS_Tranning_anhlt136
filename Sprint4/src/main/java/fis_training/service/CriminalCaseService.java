package fis_training.service;



import fis_training.enums.CaseStatus;
import fis_training.enums.CaseType;
import fis_training.entity.CriminalCase;
import fis_training.entity.Detective;

import java.util.List;
import java.util.Optional;

public interface CriminalCaseService extends AbstractService<CriminalCase> {

    List<CriminalCase> findByStatus(CaseStatus status);

}
