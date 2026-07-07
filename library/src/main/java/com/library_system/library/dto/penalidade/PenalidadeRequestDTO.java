package com.library_system.library.dto.penalidade;

import java.time.LocalDate;

import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PenalidadeRequestDTO {
   
    @Null
    private String motivo;

    @Null
    private LocalDate dataFim;
    
    @Null
    private Long usuarioId;

}
    

