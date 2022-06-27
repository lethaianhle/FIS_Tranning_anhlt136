package fis.training.service;


import fis.training.entity.AbstractEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AbstractService<T extends AbstractEntity> {

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(Long id);

    Optional<T> findById(Long id);

    List<T> findAll();

}
