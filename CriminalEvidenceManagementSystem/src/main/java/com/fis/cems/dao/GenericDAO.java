package com.fis.cems.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T entity);

    long count();

    void delete(T entity);

    boolean existsById(Long id);
}
