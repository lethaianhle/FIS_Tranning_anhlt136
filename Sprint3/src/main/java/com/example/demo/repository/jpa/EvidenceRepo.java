package com.example.demo.repository.jpa;


import com.example.demo.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenceRepo extends JpaRepository<Evidence,Long> {

}
