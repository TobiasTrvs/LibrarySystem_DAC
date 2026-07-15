package com.library_system.library.dto.emprestimo;
import java.time.LocalDate;
import java.util.List;
import com.library_system.library.dto.itemEmprestimo.ItemEmprestimoResponseDTO;
import com.library_system.library.entity.StatusEmprestimo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoResponseDTO {

    private Long id;

    private LocalDate dataEmprestimo;

    private LocalDate dataPrevistaDevolucao;

    private LocalDate dataDevolucao;

    private StatusEmprestimo status;

    private Long usuarioId;

    private String nomeUsuario;

    private List<ItemEmprestimoResponseDTO> itens;
}