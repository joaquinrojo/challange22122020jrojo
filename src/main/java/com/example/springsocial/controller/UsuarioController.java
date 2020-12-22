/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springsocial.controller;

import com.example.springsocial.model.User;
import com.example.springsocial.negocio.UsuarioService;

import com.example.springsocial.security.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping({"/usuarios"})
public class UsuarioController {

  private UsuarioService repository;

  UsuarioController(UsuarioService contactRepository) {
      this.repository = contactRepository;
  }
  @GetMapping
  public List findAll(){
      return repository.getBaseRepo().findAll();
  }




    @GetMapping(path = {"/menu"})
    public ResponseEntity<String> menu(){
        UserPrincipal userPrincipal =(UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user=repository.findByUsid(userPrincipal.getId());

        String rol=user.getRoles();
        String menu="{\"items\": [\n" +
                "          {\"icon\":\"#dog\",\"url\":\"/admin/mascotas\",\"nombre\":\"Mascotas\"}," +
                //   "           {\"icon\":\"#dog\",\"url\":\"/admin/overview\",\"nombre\":\"Vida\"},\n" +
                "           {\"icon\":\"#person-dog\",\"url\":\"/admin/user\",\"nombre\":\"Usuario\"}" +
           //     "           {\"icon\":\"#person-dog\",\"url\":\"/admin/conocimiento\",\"nombre\":\"Conocimiento\"}" +
           //     "           {\"icon\":\"#dog-2\",\"url\":\"/admin/table-list\",\"nombre\":\"Table list\"} ,\n" +
           //     "          {\"icon\":\"#dog-2\",\"url\":\"/admin/typography\",\"nombre\":\"Typography\"} ,\n" +
            //    "          {\"icon\":\"#dog-2\",\"url\":\"/admin/maps\",\"nombre\":\"Maps\"} ,\n" +
            //    "          {\"icon\":\"#dog-2\",\"url\":\"/admin/notifications\",\"nombre\":\"Notifications\"} ,\n" +

                "        ]}";

        return new ResponseEntity<>(menu,HttpStatus.OK);
    }

}
