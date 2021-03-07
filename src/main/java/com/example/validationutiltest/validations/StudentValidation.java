package com.example.validationutiltest.validations;

import com.example.validationutiltest.dto.Professor;
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
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        log.info("validate of student");

        Student student  =  (Student)target;

        if(student.getSId() == ""){
            errors.rejectValue("sId", "119", "sId는 필수야");

            // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pid","9999");
            //  ValidationUtils.invokeValidator(new StudentValidation(), target,errors);
        }
    }
}
