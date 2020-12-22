package com.example.springsocial.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository usuarioRepository,PasswordEncoder passwordEncoder) {
        this.usuarioRepository=usuarioRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
       /*
        this.usuarioRepository.deleteAll();
        Usuario user1=new Usuario();
        user1.setUs_id("ID_JROJO");
        user1.setUsuario("jrojo");
        user1.setPassword(passwordEncoder.encode("1234"));
        user1.setRoles("ADMIN");
        user1.setActive(1);
        this.usuarioRepository.save(user1);
    */
    }

}
