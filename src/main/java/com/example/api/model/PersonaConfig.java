package com.example.api.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonaConfig {
    @Bean
    CommandLineRunner commandLineRunner(PersonaRepository personaRepository){
        return args -> {
           Persona jordi=  new Persona( "JORDI","dev" ,"text@gmail.com", 20);
            Persona alber=  new Persona( "alber", "TEST",  "text2@gmail.com",20);
            Persona prueba=  new Persona( "prueba", "TEST","text4@gmail.com" ,20);
            personaRepository.saveAll(List.of(jordi,alber,prueba));
        };
    }
}
