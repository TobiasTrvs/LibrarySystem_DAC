package com.library_system.library.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library_system.library.Service.ItemEmprestimoService;
import com.library_system.library.entity.ItemEmprestimo;

@RestController
@RequestMapping("/itens-emprestimo")

public class ItemEmprestimoController {
    private final ItemEmprestimoService service;

    public ItemEmprestimoController(ItemEmprestimoService service) {
        this.service = service;
    }

    @PostMapping
    public ItemEmprestimo salvarItem(@RequestBody ItemEmprestimo item) {
        return service.salvarItem(item);
    }

    @GetMapping
    public List<ItemEmprestimo> listarItens() {
        return service.listarItens();
    }

    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable Long id) {
        service.deletarItem(id);
    }
    
}
