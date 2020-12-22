package com.example.springsocial.negocio;

import com.example.springsocial.model.User;
import com.example.springsocial.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository mascotaRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

public UserRepository getBaseRepo(){
    return this.mascotaRepository;
}
/*
    public User findByUsername(String username){
        String sql="select * from usuario where usuario='"+username+"'";
        System.out.println("consulta"+sql);
        List<User> lista= this.getBaseRepo().getEntityManager().createNativeQuery("select * from usuario where usuario='"+username+"'",User.class).getResultList();
        return lista.get(0);
    }
*/
    public User findByUsid(String username){
        String sql="select * from users where usid='"+username+"'";
        System.out.println("consulta"+sql);
        List<User> lista= this.getBaseRepo().getEntityManager().createNativeQuery(sql,User.class).getResultList();
        return lista.get(0);
    }


}
