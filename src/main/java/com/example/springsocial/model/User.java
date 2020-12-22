package com.example.springsocial.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @JsonIgnore
    @Id
    private String usid;

    @NotEmpty(message = "Debe ingresar el nombre de usuario")
    @Column(nullable = false)
    private String name;


    private String telefono;

    @Email
    @Column(nullable = false)
    private String email;

    private String imageUrl;
    @JsonIgnore
    @Column(nullable = false)
    private Boolean emailVerified = false;

    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;
    @JsonIgnore
    private String providerId;
    @JsonIgnore
    @NotBlank(message = "Debe ingresar su rol")
    private String roles;
    @JsonIgnore
    private String permissions;

    private String descripcion;

    @JsonIgnore
    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
    @JsonIgnore
    public List<String> getPermissionsList(){

        if(this.permissions!=null && this.permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

}
