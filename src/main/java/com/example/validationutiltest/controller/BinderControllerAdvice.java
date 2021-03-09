package com.example.validationutiltest.controller;

import com.example.validationutiltest.validations.ProfessorValidation;
import com.example.validationutiltest.validations.StudentValidation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class BinderControllerAdvice {
    @InitBinder("professor")
    public void initBinderProfessor(WebDataBinder binder){
        binder.setValidator(new ProfessorValidation());
    }


    @InitBinder("student")
    public void initBinderStudent(WebDataBinder binder){
        binder.setValidator(new StudentValidation());
    }

}
