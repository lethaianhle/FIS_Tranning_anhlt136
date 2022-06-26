package com.example.demo.repo.jdpctemplate;


import com.example.demo.core.Rank;
import com.example.demo.model.Detective;
import com.example.demo.repo.jpa.AbstractRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Repository
public interface DetectiveRepo extends AbstractRepo<Detective> {

    List<Detective> findAll();
    Optional<Detective> findByBadgeNumber(String badgeNumber);
    List<Detective> findbyRank(Rank rank);

    default Optional<Detective> findByIdWithPersonDetails(Long id) {
        return Optional.empty();
    }
}