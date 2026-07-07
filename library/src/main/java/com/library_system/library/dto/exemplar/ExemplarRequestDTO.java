package com.library_system.library.dto.exemplar;
import com.library_system.library.entity.StatusExemplar;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExemplarRequestDTO {
   
    @NotBlank(message = "código obrigatório")
    private String codigoExemplar;

    @NotBlank(message = "Status obrigatório")
    private StatusExemplar status;

    @NotBlank(message = "ID obrigatório")
    private long livroId;
}
