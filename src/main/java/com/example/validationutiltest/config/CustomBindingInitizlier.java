package com.example.validationutiltest.config;

import com.example.validationutiltest.dto.Professor;
import com.example.validationutiltest.dto.Student;
import com.example.validationutiltest.validations.ProfessorValidation;
import com.example.validationutiltest.validations.StudentValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;


@Slf4j
@Component
public class CustomBindingInitizlier extends ConfigurableWebBindingInitializer{

    @Override
    public void initBinder(WebDataBinder binder) {

        if( binder.getTarget().getClass().equals(Professor.class)) {
            binder.setValidator(new ProfessorValidation());
        }
        else if( binder.getTarget().getClass().equals(Student.class)){
            binder.setValidator(new StudentValidation());
        }

    }
}

