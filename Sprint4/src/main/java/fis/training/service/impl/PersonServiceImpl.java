package fis.training.service.impl;


import fis.training.entity.Person;
import fis.training.repo.PersonRepo;
import fis.training.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepo personRepo;

    @Override
    public Person create(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person update(Person person) {
        return personRepo.save(person);
    }

    @Override
    public void delete(Person person) {
        personRepo.delete(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepo.deleteById(id);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepo.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }
}
