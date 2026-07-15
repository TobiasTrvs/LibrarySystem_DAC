package com.library_system.library.dto.penalidade;
import java.time.LocalDate;
import com.library_system.library.entity.StatusPenalidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenalidadeResponseDTO {

    private Long id;

    private String motivo;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private StatusPenalidade status;

    private Long usuarioId;

    private String nomeUsuario;
}