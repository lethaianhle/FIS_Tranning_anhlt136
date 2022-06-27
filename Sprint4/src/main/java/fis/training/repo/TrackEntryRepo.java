package fis.training.repo;

import fis.training.entity.TrackEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackEntryRepo extends JpaRepository<TrackEntry, Long> {

}
