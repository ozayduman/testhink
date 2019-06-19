package com.ozayduman.testhink.person.dto;

import com.ozayduman.testhink.person.entity.Person;

public class PersonDTO {

    private String name;

    private String surname;

    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        this.name = person.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
