package com.library_system.library.dto.usuario;
import com.library_system.library.entity.tipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private tipoUsuario tipo;
}