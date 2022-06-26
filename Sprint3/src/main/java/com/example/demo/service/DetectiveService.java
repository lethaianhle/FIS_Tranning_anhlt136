package com.example.demo.service;

import com.example.demo.model.Detective;

import java.util.List;
import java.util.Optional;

public interface DetectiveService {

    void save(Detective detective);

    List<Detective> getALl();

    Optional<Detective> findById(Long id);

    Detective update(Detective detective);

    void deleteById(Long id);

}
