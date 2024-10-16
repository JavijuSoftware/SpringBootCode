package com.javijcode.curso.springboot.webapp.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javijcode.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.javijcode.curso.springboot.webapp.springbootweb.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

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
    public ParamMixDto bar(@RequestParam() String text,@RequestParam Integer code) {
        ParamMixDto paramMixDto = new ParamMixDto();
        paramMixDto.setMessage(text);
        paramMixDto.setCode(code);
        
        return paramMixDto;
    }

    //Capitulo 28 HttpServletRequest
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));            
        } catch (NumberFormatException ex) {
        }

        ParamMixDto paramMixDto = new ParamMixDto();
        paramMixDto.setMessage(request.getParameter("message"));
        paramMixDto.setCode(code);

        return paramMixDto;
    }

}
