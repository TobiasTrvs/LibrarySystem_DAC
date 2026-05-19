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

import com.library_system.library.Service.UsuarioService;
import com.library_system.library.dto.UsuarioRequestDTO;
import com.library_system.library.entity.Usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

     @PostMapping
    public Usuario salvarUsuario(
            @Valid @RequestBody UsuarioRequestDTO dto) {

        return service.salvarUsuario(dto);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return service.ListarUsuario();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return service.buscarUsuarioPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id,
                                    @RequestBody Usuario usuario) {

        return service.atualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        service.deletarUsuario(id);
    }

}
    

