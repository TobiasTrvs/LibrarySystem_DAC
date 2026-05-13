package com.library_system.library.entity;

import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

 public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private tipoUsuario tipo;
}
