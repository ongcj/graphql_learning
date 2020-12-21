package com.example.demo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonQueryResolver implements GraphQLQueryResolver {
    private final PersonService personService;

    public PersonQueryResolver(final PersonService personService) {
        this.personService = personService;
    }

    public Collection<Person> people() {
        return personService.getPeople();
    }
}
