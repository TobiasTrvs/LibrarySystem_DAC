package com.library_system.library.dto.exemplar;
import com.library_system.library.entity.StatusExemplar;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExemplarRequestDTO {
   
    @NotBlank(message = "código obrigatório")
    private String codigoExemplar;

    @NotNull(message = "Status obrigatório")
    private StatusExemplar status;

    @NotNull(message = "ID obrigatório")
    private long livroId;
}
