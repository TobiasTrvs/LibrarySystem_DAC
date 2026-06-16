package com.library_system.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LIvroRequestDTO {

    @NotBlank( message = "título obrigatório")
    private String titulo;

    @NotBlank( message = "autor obrigatório")
    private String autor;

    @Size(min = 13, max = 13)
    @NotBlank(message = "isbn obrigatório")
    private String isbn;

    @NotBlank(message = "editora obrigatória")
    private String editora;

    @NotBlank(message = "ano de publicação obrigatório")
    private Integer anoPublicacao;
    
}
