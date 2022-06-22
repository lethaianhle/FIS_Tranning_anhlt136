package com.fis.cems.dao;

import com.fis.cems.model.Evidence;

import java.util.List;

public interface IEvidenceDAO extends GenericDAO<Evidence> {

    List<Evidence> findByCriminalNumberOnlyForSenior(String number);

}
