package com.library_system.library.dto.exemplar;
import com.library_system.library.entity.StatusExemplar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExemplarResponseDTO {

    private Long id;

    private String codigoExemplar;

    private StatusExemplar status;

    private String tituloLivro;
}