/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springsocial.controller;

import com.example.springsocial.negocio.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 *
 * @author joaquin
 */
@RestController
@CrossOrigin
@RequestMapping({"/admin"})
public class AdminController {

  private UsuarioService repository;

  AdminController(UsuarioService contactRepository) {
      this.repository = contactRepository;
  }
    @GetMapping(path = {"/usuarios"})
  public List findAll(){
      return repository.getBaseRepo().findAll();
  }

@GetMapping(path = {"/login"})
public ResponseEntity<String> login(){

      return new ResponseEntity<>("{\"status\":\"ok\"}",HttpStatus.OK);
}

}
