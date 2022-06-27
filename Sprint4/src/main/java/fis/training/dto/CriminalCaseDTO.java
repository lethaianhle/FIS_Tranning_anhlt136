package fis.training.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fis.training.entity.Evidence;
import fis.training.enums.CaseStatus;
import fis.training.enums.CaseType;
import fis.training.entity.Detective;
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

    private Set<Evidence> evidenceSet = new HashSet<>();

    private Detective leadInvestigator;

    private Set<Detective> assigned = new HashSet<>();

}
