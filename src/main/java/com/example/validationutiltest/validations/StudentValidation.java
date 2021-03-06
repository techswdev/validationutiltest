package com.example.validationutiltest.validations;

import com.example.validationutiltest.dto.Person;
import com.example.validationutiltest.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@Slf4j
public class StudentValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        log.info(" StudentValidation supports {}",clazz);

        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        log.info(" StudentValidation validate target {}",target);

    }
}
