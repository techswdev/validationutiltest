package com.example.validationutiltest.controller;

import com.example.validationutiltest.validations.ProfessorValidation;
import com.example.validationutiltest.validations.StudentValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@ControllerAdvice
@Slf4j
public class CommonControllerAdvice implements RequestBodyAdvice {

    @InitBinder("professor")
    public void initBinderProfessor(WebDataBinder binder){
        binder.setValidator(new ProfessorValidation());
    }


    @InitBinder("student")
    public void initBinderStudent(WebDataBinder binder){
        binder.setValidator(new StudentValidation());
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        //methodParameter.getParameterType()
        log.info("supports");
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
       // converterType.
        log.info("beforeBodyRead");

        return null;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.info("afterBodyRead");
        return null;
    }


    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.info("handleEmptyBody");
        return null;
    }
}
