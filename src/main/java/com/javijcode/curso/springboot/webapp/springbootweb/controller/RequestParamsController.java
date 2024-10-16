package com.javijcode.curso.springboot.webapp.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javijcode.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "foo") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam() String text,@RequestParam Integer code) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(text);
        paramDto.setCode(code);
        
        return paramDto;
    }

}
