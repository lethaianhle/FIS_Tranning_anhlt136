package fis.training.dto;

import fis.training.enums.EmploymentStatus;
import fis.training.enums.Rank;
import fis.training.entity.CriminalCase;
import fis.training.entity.Person;
import fis.training.entity.TrackEntry;
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
