package com.example.validationutiltest.controller;

import com.example.validationutiltest.dto.Person;
import com.example.validationutiltest.dto.Student;
import com.example.validationutiltest.validations.PersonValidation;
import com.example.validationutiltest.validations.StudentValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@Slf4j
public class MainController {

    @InitBinder("person")
    public void PersondataBinding(WebDataBinder binder){
        binder.setValidator(new PersonValidation());
    }

    @InitBinder("student")
    public void StudentdataBinding(WebDataBinder binder){
        binder.setValidator(new StudentValidation());

    }


    @GetMapping("/personvalitest")
    public void personvalitest( @Valid Person person, BindingResult bindingResult) throws IOException {
        log.info("Person : {}", person.toString());
        log.info("bindingResult : {}", bindingResult.toString());


    }
    @GetMapping("/studentvalitest")
    public void studentvalitest(@Valid Student student, BindingResult bindingResult){
        log.info("Student : {}", student.toString());
        log.info("bindingResult : {}", bindingResult.toString());

    }
}
