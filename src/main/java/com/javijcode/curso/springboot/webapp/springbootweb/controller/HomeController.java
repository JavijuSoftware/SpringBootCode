package com.javijcode.curso.springboot.webapp.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Capitulo 38 - Redirect y Forward
    @GetMapping({"","/","/home"})
    public String home() {

        // redirect to /list
        return "redirect:/list";
        // forward to /list
        //return "forward:/list";
    }

    /*Forward vs Redirect: "La diferencia es que con el Forward se mantiene dentro 
    de la misma petición http, y no pierdes los parámetros que tienes dentro del request, 
    tampoco cambia la ruta url, ya que no hace un refresh (refresca la página), 
    sino que despacha a otra acción del controlador pero sin recargar la página, 
    mientras que el redirect cambia la ruta url, reinicia el request y refresca el navegador, 
    además que todos los parámetros del request que teníamos antes del redirect se pierden 
    en este nuevo request."*/

}
