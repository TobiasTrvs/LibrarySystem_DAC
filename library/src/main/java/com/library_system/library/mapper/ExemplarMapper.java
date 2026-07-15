package com.library_system.library.mapper;
import com.library_system.library.dto.exemplar.ExemplarRequestDTO;
import com.library_system.library.dto.exemplar.ExemplarResponseDTO;
import com.library_system.library.entity.Exemplar;
import com.library_system.library.entity.Livro;

public class ExemplarMapper {

    public static ExemplarResponseDTO toResponseDTO(Exemplar exemplar) {

        ExemplarResponseDTO dto = new ExemplarResponseDTO();

        dto.setId(exemplar.getId());
        dto.setCodigoExemplar(exemplar.getCodigoExemplar());
        dto.setStatus(exemplar.getStatus());

        if (exemplar.getLivro() != null) {
            dto.setId(exemplar.getLivro().getId());
            dto.setTituloLivro(exemplar.getLivro().getTitulo());
        }

        return dto;
    }

    public static Exemplar toEntity(ExemplarRequestDTO dto, Livro livro) {
        Exemplar exemplar = new Exemplar();
        exemplar.setCodigoExemplar(dto.getCodigoExemplar());
        exemplar.setStatus(dto.getStatus());
        exemplar.setLivro(livro);

        return exemplar;
    }
}