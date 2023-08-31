package mvcPattern.sadstill.webLibrary.util;

import mvcPattern.sadstill.webLibrary.dao.PersonDAO;
import mvcPattern.sadstill.webLibrary.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (personDAO.getPersonByFullName(person.getName(), person.getSurname(), person.getSurname()).isPresent())
            errors.rejectValue("fullName", " ", "Человек с такой ФИО уже существует!");

    }
}
