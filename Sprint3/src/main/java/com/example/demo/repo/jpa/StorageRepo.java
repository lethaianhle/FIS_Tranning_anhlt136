package com.example.demo.repo.jpa;


import com.example.demo.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepo extends JpaRepository<Storage,Long> {

//    Optional<Storage> findByName(String name);
//
//    Optional<Storage> findByLocation(String location);
}
