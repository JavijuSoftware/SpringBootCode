package com.javijcode.curso.springboot.webapp.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
// Capitulo 33 - Inyectar valores con la anotación @Value desde el archivo values.properties
// para configurar con varios properties se utilizara @PropertySources
@PropertySources({
	@PropertySource("classpath:values.properties")
})

public class ValuesConfig {

}
