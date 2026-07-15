package com.library_system.library.dto.emprestimo;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmprestimoRequestDTO {

    @NotNull(message=" A data de empréstimo é obrigatória")
    @FutureOrPresent(message = "a data do emmpréstimo não pode ser no passado")
    private LocalDate dataEmprestimo;

    @NotBlank
    private LocalDate dataPrevistaDevolucao;

    @NotNull(message = "A data de devolução é obrigatória")
    @FutureOrPresent(message = "A data prevista deve ser atual ou futura")
    private LocalDate dataDevolucao;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long usuarioID;

    @NotNull(message = "O ID do livro é obrigatório")
    private long livroID;

    // colocar o id do empréstimo pra ser gerado em outra classe

    

    



}