package com.example.demo.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreatePersonMutationResolver implements GraphQLMutationResolver {
    private final PersonService personService;

    public CreatePersonMutationResolver(PersonService personService) {
        this.personService = personService;
    }

    public Person createPerson(final String firstName, final String lastName, final LocalDate dateOfBirth) {
        return personService.createPerson(firstName, lastName, dateOfBirth);
    }
}
