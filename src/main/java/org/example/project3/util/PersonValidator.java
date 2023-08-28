package org.example.project3.util;


import org.example.project3.Services.PeopleService;
import org.example.project3.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
private final PeopleService peopleService;
@Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if(peopleService.findByPersonName(person.getName()).isPresent()){
            errors.rejectValue("name","","This name already taken!");
        }

    }
}
