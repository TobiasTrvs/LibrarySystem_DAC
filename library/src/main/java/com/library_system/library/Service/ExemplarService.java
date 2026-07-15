package com.library_system.library.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.library_system.library.Repository.ExemplarRepository;
import com.library_system.library.Repository.LivroRepository;
import com.library_system.library.dto.exemplar.ExemplarRequestDTO;
import com.library_system.library.entity.Exemplar;
import com.library_system.library.entity.StatusExemplar;
import jakarta.transaction.Transactional;

@Service
public class ExemplarService {

     private final ExemplarRepository exemplarRepository;
     private final LivroRepository livroRepository;

    public ExemplarService(ExemplarRepository repository, LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
        this.exemplarRepository = repository;
    }

    public Exemplar salvarExemplar(ExemplarRequestDTO dto) { 
        if (exemplarRepository.existsById(dto.getLivroId())){
            throw new RuntimeException ("exemplar já cadastrado");
        }
        Exemplar exemplar = new Exemplar();
        exemplar.getCodigoExemplar();
        exemplar.getId();
        exemplar.getLivro();
        exemplar.getStatus();
        
        return exemplarRepository.save(exemplar);
    }


    public List<Exemplar> listarExemplares() {
        return exemplarRepository.findAll();
    }


    public Exemplar buscarExemplarPorId(Long id) {
        return exemplarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exemplar não encontrado"));
    }

    // alterar esse método para receber um dto de exemplar
    public Exemplar atualizarStatus(Long id, StatusExemplar status) {
        Exemplar exemplar = buscarExemplarPorId(id);
        exemplar.setStatus(status);
        return exemplarRepository.save(exemplar);
    }

    @Transactional
    public void deletarExemplar(Long id) {
        Exemplar exemplar = buscarExemplarPorId(id);
        exemplarRepository.delete(exemplar);
    }

    // esse método não faz mais sentido
    public void findByExemplarDsiponivel(ExemplarRequestDTO dto){
        if(dto.getStatus() != StatusExemplar.DISPONIVEL){
            throw new RuntimeException("exemplar indísponivel para empréstimo");
        }
    }
    // acho que faz mais sentido se eu pesquisar se o livro está disponivel ou se ele existe primeiro usando o id, pra depois buscar algum exemplar disponivel

    public List<Exemplar> findByExemplaresDisponiveis (ExemplarRequestDTO dto){
        livroRepository.findById(dto.getLivroId()).orElseThrow(() -> new RuntimeException("livro não encontrado"));
        return exemplarRepository.findByLivroIdAndStatus(dto.getLivroId(), StatusExemplar.DISPONIVEL );
    }

}

   
        
    
        
            
    
    

