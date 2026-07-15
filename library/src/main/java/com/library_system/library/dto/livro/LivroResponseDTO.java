package com.library_system.library.dto.livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroResponseDTO {

    private Long id;

    private String titulo;

    private String autor;

    private String isbn;

    private String editora;

    private Integer anoPublicacao;

    private Integer quantidadeExemplares;

    private Integer exemplaresDisponiveis;
}