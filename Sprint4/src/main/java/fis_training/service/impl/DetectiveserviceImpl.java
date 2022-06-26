package fis_training.service.impl;

import fis_training.entity.Detective;
import fis_training.repo.DetectiveRepo;
import fis_training.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetectiveserviceImpl implements DetectiveService {
    @Autowired
    private DetectiveRepo detectiveRepo;

    @Override
    public void delete(Detective detective) {
        detectiveRepo.delete(detective);
    }

    @Override
    public Detective create(Detective detective) {
        return detectiveRepo.save(detective);
    }

    @Override
    public Detective update(Detective detective) {
        detectiveRepo.save(detective);
        return detective;
    }

    @Override
    public void deleteById(Long id) {
        detectiveRepo.deleteById(id);
    }

    @Override
    public Optional<Detective> findById(Long id) {
        return detectiveRepo.findById(id);
    }

    @Override
    public List<Detective> findAll() {
        return detectiveRepo.findAll();
    }

}
