package com.library_system.library.dto.usuario;
import com.library_system.library.entity.tipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    private String email;

    @Size(max = 6, message = "Senha deve ter no mínimo 6 caracteres")
    @NotBlank
    private String senha;

    @NotBlank
    private String  telefone;

    private tipoUsuario tipo;
}