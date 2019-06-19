package com.ozayduman.testhink.person.service;

import com.ozayduman.testhink.person.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersonsBySurname(String surname);

    void savePerson(Person person);
}
