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
        Person person1  =  (Person)target;

        System.out.println("person = " + person1.toString());

        if(person1.getPid() == ""){
           errors.rejectValue("pid", "119", "pid는 필수야");

            // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pid","9999");
            //  ValidationUtils.invokeValidator(new StudentValidation(), target,errors);
        }
    }
}
