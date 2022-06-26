package fis_training.dto;

import fis_training.entity.CriminalCase;
import fis_training.entity.Storage;
import fis_training.entity.TrackEntry;
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
