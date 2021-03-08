package com.example.validationutiltest.controller;

import com.example.validationutiltest.dto.Professor;
import com.example.validationutiltest.dto.Student;
import com.example.validationutiltest.validations.ProfessorValidation;
import com.example.validationutiltest.validations.StudentValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/highSchool")
public class HighSchoolController {

    @PostMapping("/professor")
    public ResponseEntity<?> professorRegister(  @Valid @RequestBody Professor professor, BindingResult bindingResult) {


        if(bindingResult.hasErrors()) {

            String field = bindingResult.getFieldError().getField();
            String fieldErroMsg = bindingResult.getFieldError().getDefaultMessage();
            return new ResponseEntity<>(fieldErroMsg, HttpStatus.BAD_REQUEST);
        }
        return null;

    }
    @PostMapping("/student")
    public ResponseEntity<?> studentRegister( @Valid @RequestBody Student student, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {

            String field = bindingResult.getFieldError().getField();
            String fieldErroMsg = bindingResult.getFieldError().getDefaultMessage();
            return new ResponseEntity<>(fieldErroMsg, HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @GetMapping("/professor")
    public ResponseEntity<?> professorInfo(  @Valid  Professor professor, BindingResult bindingResult) {


        if(bindingResult.hasErrors()) {

            String field = bindingResult.getFieldError().getField();
            String fieldErroMsg = bindingResult.getFieldError().getDefaultMessage();
            return new ResponseEntity<>(fieldErroMsg, HttpStatus.BAD_REQUEST);
        }
        return null;

    }
    @GetMapping("/student")
    public ResponseEntity<?> studentInfo(  @Valid Student student, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {

            String field = bindingResult.getFieldError().getField();
            String fieldErroMsg = bindingResult.getFieldError().getDefaultMessage();
            return new ResponseEntity<>(fieldErroMsg, HttpStatus.BAD_REQUEST);
        }
        return null;
    }


}
