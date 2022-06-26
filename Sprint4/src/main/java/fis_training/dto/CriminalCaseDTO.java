package fis_training.dto;

import fis_training.enums.CaseStatus;
import fis_training.enums.CaseType;
import fis_training.entity.Detective;
import fis_training.entity.Evidence;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriminalCaseDTO {

    private String number;

    private CaseType type;

    private String shortDescription;

    private String detailedDescription;

    private CaseStatus status;

    private String notes;

//    private Set<Evidence> evidenceSet = new HashSet<>();

    private Detective leadInvestigator;

//    private Set<Detective> assigned = new HashSet<>();

}
