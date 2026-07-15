package com.library_system.library.mapper;

import java.time.LocalDate;
import com.library_system.library.dto.penalidade.PenalidadeRequestDTO;
import com.library_system.library.dto.penalidade.PenalidadeResponseDTO;
import com.library_system.library.entity.Penalidade;
import com.library_system.library.entity.StatusPenalidade;
import com.library_system.library.entity.Usuario;

public class PenalidadeMapper {

    public static PenalidadeResponseDTO toResponseDTO(Penalidade penalidade) {

        PenalidadeResponseDTO dto = new PenalidadeResponseDTO();

        dto.setId(penalidade.getId());
        dto.setMotivo(penalidade.getMotivo());
        dto.setDataInicio(penalidade.getDataInicio());
        dto.setDataFim(penalidade.getDataFim());
        dto.setStatus(penalidade.getStatus());

        if (penalidade.getUsuario() != null) {
            dto.setUsuarioId(penalidade.getUsuario().getId());
            dto.setNomeUsuario(penalidade.getUsuario().getNome());
        }

        return dto;
    }

    public static Penalidade toEntity(
            PenalidadeRequestDTO dto,
            Usuario usuario) {

        Penalidade penalidade = new Penalidade();

        penalidade.setMotivo(dto.getMotivo());
        penalidade.setDataInicio(LocalDate.now());
        penalidade.setDataFim(dto.getDataFim());
        penalidade.setStatus(StatusPenalidade.ATIVA);
        penalidade.setUsuario(usuario);

        return penalidade;
    }
}
