package com.example.demo.repository.jpa;


import com.example.demo.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CriminalCaseRepo extends JpaRepository<CriminalCase,Long> {

}
