package com.example.api.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {

@Query("SELECT s FROM Persona s WHERE s.email= ?1")
    Optional<Persona> findPersona(String email);
    @Query("SELECT s FROM Persona s WHERE s.id= ?1")
    Optional<Persona> findPersonabyid(Long id);

}
