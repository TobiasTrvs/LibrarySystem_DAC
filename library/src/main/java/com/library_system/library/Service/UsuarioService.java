package com.library_system.library.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library_system.library.Repository.UsuarioRepostitory;
import com.library_system.library.entity.Usuario;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepostitory repository;

    public UsuarioService(UsuarioRepostitory repository){
        this.repository = repository;
    }

    public Usuario salvarUsuario(Usuario usuario){
        return repository.saveAndFlush(usuario);
    }

    public List<Usuario>ListarUsuario(){
        return repository.findAll();
    }

    @Transactional
    public void deletarUsuario(Long id){
        repository.deleteById(id);
    }


    public Usuario buscarUsuarioPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {

        Usuario usuario = buscarUsuarioPorId(id);

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setSenha(usuarioAtualizado.getSenha());
        usuario.setTelefone(usuarioAtualizado.getTelefone());
        usuario.setTipo(usuarioAtualizado.getTipo());

        return repository.save(usuario);
    }


   
    
}
