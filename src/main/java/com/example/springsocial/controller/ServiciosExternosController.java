/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springsocial.controller;

import com.example.springsocial.model.*;

import com.example.springsocial.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author joaquin
 */
@RestController
@CrossOrigin
@RequestMapping({"/externos"})
public class ServiciosExternosController {


    @Autowired
    private PersonaRepository repository;


    @GetMapping(path = {"/persona/{rut}"})
    public Persona findById(@PathVariable String rut){
        Persona masc=repository.findByIdObject(rut);

        return masc;
    }


}
