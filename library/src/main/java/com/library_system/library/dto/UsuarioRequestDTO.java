package com.library_system.library.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    private String email;

    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    private String senha;

    private String  telefone;
}