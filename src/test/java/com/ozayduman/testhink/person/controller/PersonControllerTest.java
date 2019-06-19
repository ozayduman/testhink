package com.ozayduman.testhink.person.controller;

import com.ozayduman.testhink.person.dto.PersonDTO;
import com.ozayduman.testhink.person.entity.Person;
import com.ozayduman.testhink.person.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonControllerImpl controller;

   /* @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/

    @Test
    public void listNamesOfPeopleBy() {
        List<Person> people = List.of(new Person("a", "b"));
        ArgumentCaptor<String> surnameArgumentCaptor = ArgumentCaptor.forClass(String.class);
        when(personService.getPersonsBySurname(Mockito.anyString())).thenReturn(people);

        List<PersonDTO> b = controller.listNamesOfPeopleBy("b");

        verify(personService).getPersonsBySurname(surnameArgumentCaptor.capture());
        Assert.assertTrue(surnameArgumentCaptor.getValue().equals("b"));
        Assert.assertEquals("a",b.stream().findFirst().get().getName());

        Mockito.verifyNoMoreInteractions(personService);
    }

}