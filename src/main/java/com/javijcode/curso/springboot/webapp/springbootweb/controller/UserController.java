package com.javijcode.curso.springboot.webapp.springbootweb.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.javijcode.curso.springboot.webapp.springbootweb.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("SpringBoot", "Spring");

        user.setEmail("spring@boot.io");
        model.addAttribute("title", "Prueba APP");
        model.addAttribute("user", user);
        
        return "details";
    }


    @GetMapping("/list")
    public String getMethodName(ModelMap modelMap) {
        modelMap.addAttribute("title", "Listado de usuarios");        
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
            new User("String01", "StringBoot01", "spring1@boot.io"), 
            new User("String02", "StringBoot02"), 
            new User("String03", "StringBoot03", "spring3@boot.io"));
    }    

}
