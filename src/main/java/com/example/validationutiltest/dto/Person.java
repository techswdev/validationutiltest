package com.example.validationutiltest.dto;


import com.example.validationutiltest.annotations.ParamCheck;
import com.example.validationutiltest.annotations.validcheckes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//@validcheckes
//@ParamCheck(message = "파라미터 체크")
public class Person {

    private String pname;
    private String pid;
    private String pphoneNum;

}
