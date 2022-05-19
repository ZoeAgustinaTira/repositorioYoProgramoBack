package com.portfolio.portfolio.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio.model.Person;
import com.portfolio.portfolio.repository.IPersonRepository;
import com.portfolio.portfolio.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person find(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            return mapper.convertValue(person, Person.class);
        }
        return null;
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}
