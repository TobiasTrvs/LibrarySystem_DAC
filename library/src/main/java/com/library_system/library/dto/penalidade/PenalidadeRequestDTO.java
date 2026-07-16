package com.library_system.library.dto.penalidade;

import java.time.LocalDate;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenalidadeRequestDTO {
   
    @Null(message = "motivo é obrigatório")
    private String motivo;

    @Null(message = "data de encerramento da penalidade é obrigatória")
    private LocalDate dataFim;
    
    @Null(message = "id do usuário obrigatório")
    private Long usuarioId;

}
    

