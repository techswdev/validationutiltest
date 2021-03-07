package com.example.validationutiltest.validations;

import com.example.validationutiltest.dto.Professor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@Slf4j
public class ProfessorValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Professor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Professor professor  =  (Professor)target;

        if(professor.getPId() == ""){
           errors.rejectValue("pId", "119", "pid는 필수야");

            // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pid","9999");
            //  ValidationUtils.invokeValidator(new StudentValidation(), target,errors);
        }
    }
}
