package com.example.api.model;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getStudents() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getPersona(Long idPersona){

        Optional<Persona> personabyid =  personaRepository.findPersonabyid(idPersona);
        if(!personabyid.isPresent()){
            throw new IllegalStateException("No existe el id ");
        }
        return personabyid;
    }
    public void addNewPerson(Persona persona){
        Optional<Persona> personabyname =  personaRepository.findPersona(persona.getEmail());
        if(personabyname.isPresent()){
            throw new IllegalStateException("persona is take");
        }
        else{
            personaRepository.save(persona);
            System.out.println("Se ha generado correctamente");
        }
        System.out.println(persona);
    }

    public void deletePerson(Long idPersona) {

        boolean existe =personaRepository.existsById(idPersona);
        if(!existe){
            throw new IllegalStateException("no existe la persona con el id"+idPersona);

        }
        else {
            personaRepository.deleteById(idPersona);
        }




    }
    @Transactional
    public void updatePersona(Long idPersona, String name, String email) {
        Persona persona = personaRepository.findById(idPersona).orElseThrow(()-> new IllegalStateException("no existe la persona con el id"+idPersona));

        if (name != null && name.length()>0 && !Objects.equals(persona.getName(),name)){
            persona.setName(name);
        }

        if (email != null && email.length()>0 && !Objects.equals(persona.getEmail(),email)){
            Optional<Persona> personaOptional = personaRepository.findPersona(email);
            if(personaOptional.isPresent()){
                throw new IllegalStateException("emial taken");
            }
            persona.setEmail(email);
        }
    }
}
