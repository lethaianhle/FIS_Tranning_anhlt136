package fis.training.dto;

import fis.training.entity.CriminalCase;
import fis.training.entity.Storage;
import fis.training.entity.TrackEntry;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvidenceDTO {

    private CriminalCase criminalCase;

    private Storage storage;

    private String number;

    private String itemName;

    private String notes;

    private boolean archived;

    private Set<TrackEntry> trackEntries = new HashSet<>();

}
