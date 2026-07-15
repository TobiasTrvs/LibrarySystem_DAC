package com.library_system.library.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library_system.library.Service.ExemplarService;
import com.library_system.library.dto.exemplar.ExemplarRequestDTO;
import com.library_system.library.dto.exemplar.ExemplarResponseDTO;
import com.library_system.library.entity.Exemplar;
import com.library_system.library.entity.StatusExemplar;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/exemplares")

public class ExemplarController {
    private final ExemplarService service;

    public ExemplarController(ExemplarService service) {
        this.service = service;
    }

    @PostMapping
    public ExemplarResponseDTO salvarExemplar( @Valid @RequestBody ExemplarRequestDTO dto) {
        return service.salvarExemplar(dto);
    }

    @GetMapping
    public List<Exemplar> listarExemplares() {
        return service.listarExemplares();
    }

    @GetMapping("/{id}")
    public Exemplar buscarExemplarPorId(@PathVariable Long id) {
        return service.buscarExemplarPorId(id);
    }

    @PutMapping("/{id}/status")
    public Exemplar atualizarStatus(@PathVariable Long id,
                                    @RequestParam StatusExemplar status) {

        return service.atualizarStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deletarExemplar(@PathVariable Long id) {
        service.deletarExemplar(id);
    }
    
}
