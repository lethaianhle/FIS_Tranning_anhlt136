package fis_training.repo;


import fis_training.entity.Detective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectiveRepo extends JpaRepository<Detective,Long> {

}