package com.library_system.library.mapper;
import com.library_system.library.dto.livro.LIvroRequestDTO;
import com.library_system.library.dto.livro.LivroResponseDTO;
import com.library_system.library.entity.Livro;
import com.library_system.library.entity.StatusExemplar;

public class LivroMapper {

    public static LivroResponseDTO toResponseDTO(Livro livro) {

        LivroResponseDTO dto = new LivroResponseDTO();

        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setAutor(livro.getAutor());
        dto.setIsbn(livro.getIsbn());
        dto.setEditora(livro.getEditora());
        dto.setAnoPublicacao(livro.getAnoPublicacao());

        if (livro.getExemplares() != null) {
            dto.setQuantidadeExemplares(livro.getExemplares().size());

            dto.setExemplaresDisponiveis(
                    (int) livro.getExemplares()
                            .stream()
                            .filter(exemplar ->
                                    exemplar.getStatus() == StatusExemplar.DISPONIVEL)
                            .count()
            );
        } else {
            dto.setQuantidadeExemplares(0);
            dto.setExemplaresDisponiveis(0);
        }

        return dto;
    }

    public static Livro toEntity(LIvroRequestDTO dto) {

        Livro livro = new Livro();

        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setIsbn(dto.getIsbn());
        livro.setEditora(dto.getEditora());
        livro.setAnoPublicacao(dto.getAnoPublicacao());

        return livro;
    }
}