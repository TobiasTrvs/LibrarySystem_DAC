package com.library_system.library.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.library_system.library.Repository.UsuarioRepostitory;
import com.library_system.library.dto.usuario.UsuarioRequestDTO;
import com.library_system.library.entity.Usuario;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepostitory repository;

    public UsuarioService(UsuarioRepostitory repository){
        this.repository = repository;
    }

   public Usuario salvarUsuario(UsuarioRequestDTO dto) {

        if(repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Usuário já cadastrado");
        }

        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setTelefone(dto.getTelefone());
        return repository.save(usuario);
    }

    public List<Usuario>ListarUsuario(){
        return repository.findAll();
    }

    @Transactional
    public void deletarUsuario(Long id){
        if(repository.existsById(id)){
            throw new RuntimeException( "Esse usuário não existe");
        }

        Usuario usuario = buscarUsuarioPorId(id);
        repository.delete(usuario);
    }


    public Usuario buscarUsuarioPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Esse usuário não existe"));
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
