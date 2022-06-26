package com.example.demo.service.impl;

import com.example.demo.model.Detective;
import com.example.demo.repository.jdpctemplate.DetectiveRepo;
import com.example.demo.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

public class DetectiveServiceImpl implements DetectiveService {
    @Autowired
    @Qualifier("extraDetectiveRepoImpl")
    private DetectiveRepo detectiveRepo;

    @Override
    public void save(Detective detective) {
        detectiveRepo.save(detective);
    }

    @Override
    public List<Detective> getALl() {
        return detectiveRepo.findAll();
    }

    @Override
    public Optional<Detective> findById(Long id) {
        return detectiveRepo.findById(id);
    }

    @Override
    public Detective update(Detective detective) {
        return detectiveRepo.update(detective);
    }

    @Override
    public void deleteById(Long id) {
        detectiveRepo.deleteById(id);
    }
}
