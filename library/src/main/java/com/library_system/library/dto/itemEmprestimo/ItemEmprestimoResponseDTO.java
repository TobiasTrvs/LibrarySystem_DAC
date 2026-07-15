package com.library_system.library.dto.itemEmprestimo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEmprestimoResponseDTO {

    private Long id;

    private Long exemplarId;

    private String codigoExemplar;

    private String tituloLivro;
}