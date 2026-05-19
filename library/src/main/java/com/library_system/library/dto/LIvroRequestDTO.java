package com.library_system.library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LIvroRequestDTO {

    @NotBlank( message = "título obrigatório")
    private String titulo;

    @NotBlank( message = "autor obrigatório")
    private String autor;

    @NotBlank(message = "isbn obrigatório")
    private String isbn;

    @NotBlank(message = "editora obrigatória")
    private String editora;

    @NotBlank(message = "ano de publicação obrigatório")
    private Integer anoPublicacao;
    
}
