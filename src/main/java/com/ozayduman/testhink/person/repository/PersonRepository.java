package com.ozayduman.testhink.person.repository;

import com.ozayduman.testhink.person.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Long> {
    List<Person> findBysurname(String surname);
}
