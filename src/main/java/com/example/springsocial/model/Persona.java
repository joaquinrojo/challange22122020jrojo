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
@Table(name = "persona", uniqueConstraints = {
        @UniqueConstraint(columnNames = "rut")
})
public class Persona {
    @Id
    private String rut;

    private String nombre;
    private String apellido;
    private String fecha_nac;





}
