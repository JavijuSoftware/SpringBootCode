package com.javijcode.curso.springboot.webapp.springbootweb.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javijcode.curso.springboot.webapp.springbootweb.models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping(path="/details")
    public Map<String,Object> details(){

        User user = new User("SpringBoot", "Spring");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Prueba APP");
        body.put("user", user);
       
        return body;
    }
    
}
