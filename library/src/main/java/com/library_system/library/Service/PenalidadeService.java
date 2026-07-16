package com.library_system.library.Service;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import com.library_system.library.Repository.EmprestimoRepository;
import com.library_system.library.Repository.PenalidadeRepository;
import com.library_system.library.Repository.UsuarioRepostitory;
import com.library_system.library.dto.penalidade.PenalidadeRequestDTO;
import com.library_system.library.entity.Penalidade;
import com.library_system.library.entity.StatusPenalidade;
import com.library_system.library.entity.Usuario;

@Service
public class PenalidadeService {

    private final PenalidadeRepository repository;
    private final UsuarioRepostitory usuarioRepository;
    private final EmprestimoRepository emprestimoRepository;
    private Usuario usuario;
                         
    public PenalidadeService(PenalidadeRepository repository, UsuarioRepostitory usuarioRepository, EmprestimoRepository emprestimoRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.emprestimoRepository = emprestimoRepository;
        

    }

    //aplicar penalidade
    public Penalidade aplicarPenalidade(PenalidadeRequestDTO dto){
        usuario = usuarioRepostitory.findById(dto.getUsuarioId());
        if(repository.existsByUsuarioIdAndStatus(dto.getUsuarioId(), StatusPenalidade.ATIVA)){
            throw new RuntimeException("Usuário possui penalidade ativa.");      
                }
                Penalidade penalidade  = new Penalidade();        
                penalidade.setMotivo(dto.getMotivo());
                penalidade.setDataInicio(LocalDate.now());
                penalidade.setDataFim(dto.getDataFim());
                penalidade.setStatus(StatusPenalidade.ATIVA);
                penalidade.setUsuario(usuario);
                return repository.save(penalidade);
                }
    }        

    
