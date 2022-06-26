package fis_training.dto;

import fis_training.enums.EmploymentStatus;
import fis_training.enums.Rank;
import fis_training.entity.CriminalCase;
import fis_training.entity.Person;
import fis_training.entity.TrackEntry;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetectiveDTO {

    private Person person;

    private String badgeNumber;

    private Rank rank;

    private boolean armed;

    private EmploymentStatus status;

    private Set<CriminalCase> criminalCaseSet;

    private Set<TrackEntry> trackEntrySet;

}
