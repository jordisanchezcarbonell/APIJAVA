package com.example.api.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/persona")
public class PersonaController {


    private final PersonaService personaService;
    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    @GetMapping
    public List<Persona> getStudents(){
        return personaService.getStudents();
    }
    @GetMapping(path = "{idPersona}")
    public Optional<Persona> getPersona(@PathVariable("idPersona") Long idPersona){
        return personaService.getPersona(idPersona);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.OK, reason = "Se ha añadido un nuevo user")

    public void  registerNewPerson( @RequestBody Persona persona){
        personaService.addNewPerson(persona);

    }
    @PutMapping(path = "{idPersona}")
    public void updatePersona(@PathVariable("idPersona") Long idPersona,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){

        personaService.updatePersona(idPersona,name,email);
    }
    @DeleteMapping(path = "{idPersona}")
    public void  deletePerson( @PathVariable("idPersona") Long idPersona){
        personaService.deletePerson(idPersona);

    }
}
