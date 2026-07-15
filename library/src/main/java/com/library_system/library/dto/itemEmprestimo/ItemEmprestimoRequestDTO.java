package com.library_system.library.dto.itemEmprestimo;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ItemEmprestimoRequestDTO {

    @NotNull(message = "O ID do empréstimo é obrigatório")
    private Long emprestimoId;

    @NotNull(message = "O ID do exemplar é obrigatório")
    private Long exemplarId;
}
