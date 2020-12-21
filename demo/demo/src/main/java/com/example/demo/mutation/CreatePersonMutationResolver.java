package com.example.demo.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonMutationResolver implements GraphQLMutationResolver {
    private final PersonService personService;

    public CreatePersonMutationResolver(PersonService personService) {
        this.personService = personService;
    }

    public Person createPerson(final String firstName, final String lastName) {
        return personService.createPerson(firstName, lastName);
    }
}
