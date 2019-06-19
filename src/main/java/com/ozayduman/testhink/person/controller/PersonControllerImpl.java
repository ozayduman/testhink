package com.ozayduman.testhink.person.controller;

import com.ozayduman.testhink.person.dto.PersonDTO;
import com.ozayduman.testhink.person.entity.Person;
import com.ozayduman.testhink.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class PersonControllerImpl implements PersonController {
    private final PersonService personService;

    public PersonControllerImpl(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/person/{surname}")
    @Override
    public List<PersonDTO> listNamesOfPeopleBy(@PathVariable String surname){
        return personService.getPersonsBySurname(surname).stream().map(PersonDTO::new).collect(toList());
    }

    @Override
    @RequestMapping(value = "/person/save", method = RequestMethod.POST)
    public void savePerson(@RequestBody PersonDTO personDTO){
        Person person = new Person.Builder()
                .withName(personDTO.getName())
                .withSurname(personDTO.getSurname())
                .build();

        personService.savePerson(person);
    }
}
