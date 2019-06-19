package com.ozayduman.testhink.person.repository;

import com.ozayduman.testhink.person.entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void retrievePersonAfterSave() {

        Person.Builder builder = new Person.Builder();
        Person person = builder.withName("Name")
                .withSurname("Surname")
                .build();
        personRepository.save(person);

        List<Person> listOfPerson = personRepository.findBysurname("Surname");

        Assert.assertEquals(1,listOfPerson.size());
    }
}