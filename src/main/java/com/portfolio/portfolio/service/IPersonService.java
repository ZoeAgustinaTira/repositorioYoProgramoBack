package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Person;

import java.util.Set;

public interface IPersonService {
    Person savePerson(Person person);

    Person find(Integer id);

    Person updatePerson(Person person);

    void deletePerson(Integer id);

}
