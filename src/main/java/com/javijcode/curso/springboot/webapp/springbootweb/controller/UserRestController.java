package com.javijcode.curso.springboot.webapp.springbootweb.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javijcode.curso.springboot.webapp.springbootweb.models.User;
import com.javijcode.curso.springboot.webapp.springbootweb.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping(path="/detailsMap")
    public Map<String,Object> detailsMaps(){

        User user = new User("SpringBootMap", "SpringMap");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Prueba APP");
        body.put("user", user);
       
        return body;
    }
    

    @GetMapping(path="/detailsList")
    public List<User> list(){
        User user = new User("String01", "StringBoot01");
        User user2 = new User("String02", "StringBoot02");
        User user3 = new User("String03", "StringBoot03");

        //List<User> users = List.of(user, user2, user3);
        List<User> users = Arrays.asList(user, user2, user3);
        return users;
    }

    @GetMapping(path="/details")
    public UserDto details(){

        UserDto userDto = new UserDto();

        User user = new User("SpringBoot", "Spring");
        userDto.setUser(user);
        userDto.setTitle("Prueba APP");
    
        return userDto;
    }
}
