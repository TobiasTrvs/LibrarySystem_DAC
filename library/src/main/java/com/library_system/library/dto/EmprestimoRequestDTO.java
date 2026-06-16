package com.library_system.library.dto;

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

    private long emprestimoID;

    

    



}