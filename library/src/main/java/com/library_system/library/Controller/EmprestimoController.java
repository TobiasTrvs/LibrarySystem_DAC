package com.library_system.library.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library_system.library.Service.EmprestimoService;
import com.library_system.library.entity.Emprestimo;

@RestController
@RequestMapping("/emprestimos")

public class EmprestimoController {
      private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @PostMapping
    public Emprestimo realizarEmprestimo(@RequestBody Emprestimo emprestimo) {
        return service.realizarEmprestimo(emprestimo);
    }

    @GetMapping
    public List<Emprestimo> listarEmprestimos() {
        return service.listarEmprestimos();
    }

    @GetMapping("/{id}")
    public Emprestimo buscarEmprestimoPorId(@PathVariable Long id) {
        return service.buscarEmprestimoPorId(id);
    }

    @PutMapping("/{id}/devolucao")
    public Emprestimo registrarDevolucao(@PathVariable Long id) {
        return service.registrarDevolucao(id);
    }

    @DeleteMapping("/{id}")
    public void deletarEmprestimo(@PathVariable Long id) {
        service.deletarEmprestimo(id);
    }
    
}
