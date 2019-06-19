package com.ozayduman.testhink;

import com.ozayduman.testhink.person.entity.Person;
import com.ozayduman.testhink.person.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TesthinkApplication {
    Logger log = LoggerFactory.getLogger(TesthinkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TesthinkApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner demo(PersonRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Person("Jack", "Bauer"));
            repository.save(new Person("Chloe", "O'Brian"));
            repository.save(new Person("Kim", "Bauer"));
            repository.save(new Person("David", "Palmer"));
            repository.save(new Person("Michelle", "Dessler"));

            // fetch all customers
            log.info("Persons found with findAll():");
            log.info("-------------------------------");
            for (Person person : repository.findAll()) {
                log.info(person.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(person -> {
                        log.info("Person found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(person.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Person found with findBySurname('Bauer'):");
            log.info("--------------------------------------------");
            repository.findBysurname("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }

}
