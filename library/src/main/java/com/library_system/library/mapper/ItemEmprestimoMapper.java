package com.library_system.library.mapper;
import com.library_system.library.dto.itemEmprestimo.ItemEmprestimoRequestDTO;
import com.library_system.library.dto.itemEmprestimo.ItemEmprestimoResponseDTO;
import com.library_system.library.entity.Emprestimo;
import com.library_system.library.entity.Exemplar;
import com.library_system.library.entity.ItemEmprestimo;

public class ItemEmprestimoMapper {

    public static ItemEmprestimoResponseDTO toResponseDTO(
            ItemEmprestimo item) {

        ItemEmprestimoResponseDTO dto =
                new ItemEmprestimoResponseDTO();

        dto.setId(item.getId());

        if (item.getExemplar() != null) {
            dto.setExemplarId(item.getExemplar().getId());
            dto.setCodigoExemplar(
                    item.getExemplar().getCodigoExemplar());

            if (item.getExemplar().getLivro() != null) {
                dto.setLivroId(
                        item.getExemplar().getLivro().getId());

                dto.setTituloLivro(
                        item.getExemplar().getLivro().getTitulo());
            }
        }

        return dto;
    }

    public static ItemEmprestimo toEntity(
            ItemEmprestimoRequestDTO dto,
            Emprestimo emprestimo,
            Exemplar exemplar) {

        ItemEmprestimo item = new ItemEmprestimo();

        item.setEmprestimo(emprestimo);
        item.setExemplar(exemplar);

        return item;
    }

    public static ItemEmprestimo toEntity(
            Emprestimo emprestimo,
            Exemplar exemplar) {

        ItemEmprestimo item = new ItemEmprestimo();

        item.setEmprestimo(emprestimo);
        item.setExemplar(exemplar);

        return item;
    }
}