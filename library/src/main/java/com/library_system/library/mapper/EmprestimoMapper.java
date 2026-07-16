package com.library_system.library.mapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.library_system.library.dto.emprestimo.EmprestimoResponseDTO;
import com.library_system.library.dto.itemEmprestimo.ItemEmprestimoResponseDTO;
import com.library_system.library.entity.Emprestimo;
import com.library_system.library.entity.StatusEmprestimo;
import com.library_system.library.entity.Usuario;

public class EmprestimoMapper {

    public static EmprestimoResponseDTO toResponseDTO(
            Emprestimo emprestimo) {

        EmprestimoResponseDTO dto = new EmprestimoResponseDTO();

        dto.setId(emprestimo.getId());
        dto.setDataEmprestimo(emprestimo.getDataEmprestimo());
        dto.setDataPrevistaDevolucao(
                emprestimo.getDataPrevistaDevolucao());
        dto.setDataDevolucao(emprestimo.getDataDevolucao());
        dto.setStatus(emprestimo.getStatus());

        if (emprestimo.getUsuario() != null) {
            dto.setUsuarioId(emprestimo.getUsuario().getId());
            dto.setNomeUsuario(emprestimo.getUsuario().getNome());
        }

        if (emprestimo.getItens() != null) {
            List<ItemEmprestimoResponseDTO> itensDTO =
                    emprestimo.getItens()
                            .stream()
                            .map(ItemEmprestimoMapper::toResponseDTO)
                            .collect(Collectors.toList());

            dto.setItens(itensDTO);
        }

        return dto;
    }

    public static Emprestimo toEntity(Usuario usuario) {

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataPrevistaDevolucao(
                LocalDate.now().plusDays(7));
        emprestimo.setStatus(StatusEmprestimo.ATIVO);

        return emprestimo;
    }
}
