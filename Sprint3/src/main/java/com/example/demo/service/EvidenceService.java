package com.example.demo.service;



import com.example.demo.model.CriminalCase;
import com.example.demo.model.Evidence;
import com.example.demo.model.Storage;

import java.util.List;
import java.util.Optional;

public interface EvidenceService {
    List<Evidence> findByCriminalCase(CriminalCase criminalCase);
    Optional<Evidence> findByNumber(String evidenceNumber);
    boolean isInStorage(Storage storage);
}
