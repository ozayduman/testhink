package com.ozayduman.testhink.person.controller;

import com.ozayduman.testhink.person.dto.PersonDTO;
import com.ozayduman.testhink.person.repository.PersonRepository;
import com.ozayduman.testhink.person.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {PersonControllerSpringContextTest.SpringConfig.class})
//@ComponentScan(basePackages = {"com.ozayduman.testhink.person"})
public class PersonControllerSpringContextTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonControllerImpl personController;


    @Test
    public void listNamesOfPeopleBy() {
        List<PersonDTO> list = personController.listNamesOfPeopleBy("a");
        Assert.assertEquals(0, list.size());
    }

    @Configuration
   // @ComponentScan("com.ozayduman.testhink.person")
     class SpringConfig {

    }

}