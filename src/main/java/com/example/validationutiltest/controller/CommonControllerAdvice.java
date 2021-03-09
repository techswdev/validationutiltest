package com.example.validationutiltest.controller;

import com.example.validationutiltest.dto.Student;
import com.example.validationutiltest.validations.ProfessorValidation;
import com.example.validationutiltest.validations.StudentValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonInputMessage;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

@ControllerAdvice
@Slf4j
public class CommonControllerAdvice implements RequestBodyAdvice {



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
        InputStream in = inputMessage.getBody();


        String text  = IOUtils.toString(inputMessage.getBody(), StandardCharsets.UTF_8);
        System.out.println("text = " + text);

        InputStream targetStream = IOUtils.toInputStream(text);

//        int i;
//        char c;
//        while((i=in.read()) != -1) {
//            c = (char)i;
//            System.out.print(c);
//        }

      //  converterType.

       // MappingJacksonInputMessage msg = new MappingJacksonInputMessage();
        return new MappingJacksonInputMessage(targetStream, inputMessage.getHeaders());
       // return new MappingJacksonInputMessage();
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.info("afterBodyRead");


        String clznm = parameter.getParameterType().getName();
        Class c = null;
        Object o =null;
        ObjectMapper om = new ObjectMapper();

        try {
             c = Class.forName(clznm);
             o = c.getDeclaredConstructor().newInstance();
           // om.readValue()

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException  e) {
            e.printStackTrace();
        }


//        try {
//            Class  clazz = Class.forName(targetType.getTypeName());
//            Object c = clazz.getConstructor().newInstance();
//        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }

        //String text  = IOUtils.toString(inputMessage.getBody(), StandardCharsets.UTF_8);
        Student s = new Student();
        s.setSId("");
        s.setSName("sname");
        s.setSPhoneNum("s010");
        return s;
    }


    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.info("handleEmptyBody");
        return null;
    }
}
