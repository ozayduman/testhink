package com.ozayduman.testhink.person.service;

import com.ozayduman.testhink.person.entity.Person;
import com.ozayduman.testhink.person.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class PersonServiceImplTest {

    @Test
    public void shouldExcludePersonsWithNameStartingWithB() {
        PersonRepository repository = Mockito.mock(PersonRepository.class);
        Mockito.when(repository.findBysurname(Mockito.anyString()))
                .thenReturn(List.of(
                        new Person.Builder().withName("baldeung").build(),
                        new Person.Builder().withName("baldeung").build(),
                        new Person.Builder().withName("Baldeung").build()
                        )
                );

        PersonServiceImpl personService = new PersonServiceImpl(repository);
        List<Person> resultList = personService.getPersonsBySurname("baldeung");

        Mockito.verify(repository,Mockito.times(2));
        Assert.assertEquals(2,resultList.size());
        Assert.assertTrue(resultList.stream().filter(person -> person.getName().startsWith("B")).count()==0);
    }


}