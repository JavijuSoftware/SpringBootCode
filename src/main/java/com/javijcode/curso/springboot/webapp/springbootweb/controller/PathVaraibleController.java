package com.javijcode.curso.springboot.webapp.springbootweb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javijcode.curso.springboot.webapp.springbootweb.models.User;
import com.javijcode.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// Capitulo 29 - @PathVariable
@RestController
@RequestMapping("/api/var")
public class PathVaraibleController {

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {

        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
        
    }

    // Capituro 30 - @PathVariable
    // http://127.0.0.1:8080/api/var/mix/teclado/1231
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    // Capituro 31 - Api Rest enviar Json petición POST
    // envia desde postman POST => localhost:8080/api/var/create
    @PostMapping("/create")   
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        user.setLastname(user.getLastname().toUpperCase().concat(" ").concat("3.0"));
        //hacer algo con el usuario save en la bbdd
        
        return user;
    }
    

}
