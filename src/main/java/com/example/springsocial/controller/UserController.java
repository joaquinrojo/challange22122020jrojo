package com.example.springsocial.controller;

import com.example.springsocial.exception.ResourceNotFoundException;
import com.example.springsocial.model.User;
import com.example.springsocial.negocio.UsuarioService;
import com.example.springsocial.repository.UserRepository;
import com.example.springsocial.security.CurrentUser;
import com.example.springsocial.security.UserPrincipal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UsuarioService usuarioRepository;

    @GetMapping("/user/me")
    public User getCurrentUser() {
        UserPrincipal userPrincipal =(UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user=usuarioRepository.findByUsid(userPrincipal.getId());
        return user;
    }

    @PostMapping("/user/me")
    public User updateCurrentUser(@RequestBody String json)  throws IOException {
        User userUpdated = new ObjectMapper().readValue(json, User.class);
        UserPrincipal userPrincipal =(UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user=usuarioRepository.findByUsid(userPrincipal.getId());
        user.setName(userUpdated.getName());
        user.setDescripcion(userUpdated.getDescripcion());
        user.setTelefono(userUpdated.getTelefono());
        usuarioRepository.getBaseRepo().save(user);
        return user;
    }

}
