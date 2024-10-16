package com.javijcode.curso.springboot.webapp.springbootweb.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    // Capitulo 32 - Inyectar valores con la anotación @Value desde el archivo application.properties
    @Value("${config.username}")
    private String username;
    @Value("${config.message}")
    private String message;
    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    @Value("${config.code}")
    private Integer code;
    // Capitulo 35 - Expresion Language (SpEL) con @Value
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> listOfValues2;
    @Value("#{'${config.listOfValues}'.toUpperCase().replace(',', ' ')}")
    private String listString;
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;
    @Value("#{${config.valuesMap}.product}")
    private String product;
    @Value("#{${config.valuesMap}.price}")
    private Long price;
    @Value("#{${config.valuesMap}.description}")
    private String description;
    // Capitulo 37 - Environment
    @Autowired
    private Environment environment;

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

    // Capitulo 32 - Inyectar valores con la anotación @Value desde el archivo application.properties
    // localhost:8080/api/var/values
    @GetMapping("/values")  
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", Arrays.asList(listOfValues));
        json.put("code", code);
        json.put("listOfValues2", listOfValues2);
        json.put("listString", listString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        json.put("description", description);
        return json;
    }

    // Capitulo 37 - Enverioment
    @GetMapping("/valuesEnverioment")  
    public Map<String, Object> valuesEnveriomente() {
        Map<String, Object> json = new HashMap<>();
        Long codeLong = environment.getProperty("config.code", Long.class);

        json.put("username", username);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("listOfValues", Arrays.asList(listOfValues));
        json.put("code", code);
        json.put("codeInt", Integer.parseInt(environment.getProperty("config.code")));
        json.put("codeLong", codeLong);
        json.put("listOfValues2", listOfValues2);
        json.put("listString", listString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);        
        json.put("description", description);
        return json;
    }
    

}
