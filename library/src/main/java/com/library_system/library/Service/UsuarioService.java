package com.library_system.library.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library_system.library.Repository.UsuarioRepostitory;
import com.library_system.library.entity.Usuario;

@Service
public class UsuarioService {

    private final UsuarioRepostitory repository;

    public UsuarioService(UsuarioRepostitory repository){
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public void deletarUsuario(Usuario usuario){
        repository.delete(usuario);
    }

    public Optional <Usuario> buscarUsuarioPorID(Long id){
        return repository.findById(id);
    
    }

    public void deletarUsuarioPorId(Long id){
        repository.deleteById(id);
    }


   
    
}
