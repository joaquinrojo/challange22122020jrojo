package com.example.springsocial.repository;

import com.example.springsocial.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends ExtendedRepository<Persona, Long> {

    Optional<Persona> findByRut(String rut);


}
