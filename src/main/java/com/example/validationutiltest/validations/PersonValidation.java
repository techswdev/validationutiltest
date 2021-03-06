package com.example.validationutiltest.validations;

import com.example.validationutiltest.dto.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Slf4j
@Component
public class PersonValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ObjectMapper om = new ObjectMapper();
        String personStringValue ="";
        Person person =null;
        try {
            personStringValue = om.writeValueAsString(target);
            person =  om.readValue(personStringValue, Person.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("person = " + person.toString());

        if(person.getPid() == ""){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pid","9999");
          //  ValidationUtils.invokeValidator(new StudentValidation(), target,errors);
        }
    }
}
