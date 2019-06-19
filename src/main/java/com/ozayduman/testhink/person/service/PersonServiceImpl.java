package com.ozayduman.testhink.person.service;

import com.ozayduman.testhink.person.entity.Person;
import com.ozayduman.testhink.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.*;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersonsBySurname(final String surname){
        List<Person> persons = personRepository.findBysurname(surname);

        return persons.stream()
                .filter(person -> !person.getName().startsWith("B"))
                .collect(toList());
    }

    @Override
    public void savePerson(Person person){
        personRepository.save(person);
    }
}
