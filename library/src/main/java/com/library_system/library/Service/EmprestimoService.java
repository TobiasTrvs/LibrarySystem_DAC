package com.library_system.library.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library_system.library.Repository.EmprestimoRepository;
import com.library_system.library.entity.Emprestimo;
import com.library_system.library.entity.StatusEmprestimo;
@Service

public class EmprestimoService {
    private final EmprestimoRepository repository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public Emprestimo realizarEmprestimo(Emprestimo emprestimo) {

        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setStatus(StatusEmprestimo.ATIVO);

        return repository.save(emprestimo);
    }

    public List<Emprestimo> listarEmprestimos() {
        return repository.findAll();
    }

    public Emprestimo buscarEmprestimoPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Esse empréstimo não existe"));
    }

    public Emprestimo registrarDevolucao(Long id) {

        Emprestimo emprestimo = buscarEmprestimoPorId(id);

        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setStatus(StatusEmprestimo.FINALIZADO);

        return repository.save(emprestimo);
    }
    
}
