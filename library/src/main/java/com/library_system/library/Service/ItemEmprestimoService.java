package com.library_system.library.Service;

import com.library_system.library.entity.ItemEmprestimo;
import com.library_system.library.Repository.ItemEmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemEmprestimoService {

    private final ItemEmprestimoRepository repository;

    public ItemEmprestimoService(ItemEmprestimoRepository repository) {
        this.repository = repository;
    }

    public ItemEmprestimo salvarItem(ItemEmprestimo item) {
        return repository.save(item);
    }

    public List<ItemEmprestimo> listarItens() {
        return repository.findAll();
    }

    public void deletarItem(Long id) {
        repository.deleteById(id);
    }
}