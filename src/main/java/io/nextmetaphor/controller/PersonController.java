package io.nextmetaphor.controller;

import io.nextmetaphor.exception.BadRequestException;
import io.nextmetaphor.exception.InternalServerErrorException;
import io.nextmetaphor.exception.ResourceNotFoundException;
import io.nextmetaphor.model.PersonModel;
import io.nextmetaphor.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value="person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonModel getPersonByID(@PathVariable("id") int personId)
            throws ResourceNotFoundException, BadRequestException, InternalServerErrorException{
        PersonModel person = personService.getPersonByID(personId);

        if (person != null) {
            return person;
        } else if (personId == 404) {
            throw new ResourceNotFoundException();
        } else if (personId == 400) {
            throw new BadRequestException();
        } else {
            throw new InternalServerErrorException();
        }
    }
}
