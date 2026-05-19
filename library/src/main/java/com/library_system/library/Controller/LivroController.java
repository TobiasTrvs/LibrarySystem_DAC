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

import com.library_system.library.Service.LivroService;
import com.library_system.library.dto.LIvroRequestDTO;
import com.library_system.library.entity.Livro;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")

public class LivroController {
    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping
    public Livro salvarLivro( @Valid @RequestBody LIvroRequestDTO dto) {
        return service.salvarLivro(dto);
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return service.listarLivros();
    }

    @GetMapping("/{id}")
    public Livro buscarLivroPorId(@PathVariable Long id) {
        return service.buscarLivroPorId(id);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id,
                                @RequestBody Livro livro) {

        return service.atualizarLivro(id, livro);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        service.deletarLivro(id);
        }
    
}
