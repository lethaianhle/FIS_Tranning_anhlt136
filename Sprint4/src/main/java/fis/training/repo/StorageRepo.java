package fis.training.repo;

import fis.training.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepo extends JpaRepository<Storage, Long> {

}
