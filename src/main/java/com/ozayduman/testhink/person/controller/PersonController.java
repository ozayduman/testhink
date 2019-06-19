package com.ozayduman.testhink.person.controller;

import com.ozayduman.testhink.person.dto.PersonDTO;

import java.util.List;

public interface PersonController {
    List<PersonDTO> listNamesOfPeopleBy(String surname);
    void savePerson(PersonDTO personDTO);
}
