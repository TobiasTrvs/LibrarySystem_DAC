package com.library_system.library.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.library_system.library.Repository.ExemplarRepository;
import com.library_system.library.dto.ExemplarRequestDTO;
import com.library_system.library.entity.Exemplar;
import com.library_system.library.entity.StatusExemplar;
@Service

public class ExemplarService {
     private final ExemplarRepository repository;

    public ExemplarService(ExemplarRepository repository) {
        this.repository = repository;
    }

    public Exemplar salvarExemplar(ExemplarRequestDTO dto) {
        
        if (repository.existsById(dto.getLivroId())){
            throw new RuntimeException ("exemplar já cadastrado");
        }

        Exemplar exemplar = new Exemplar();
        exemplar.getCodigoExemplar();
        exemplar.getId();
        exemplar.getLivro();
        exemplar.getStatus();
        
        return repository.save(exemplar);
    }

    public List<Exemplar> listarExemplares() {
        return repository.findAll();
    }

    public Exemplar buscarExemplarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exemplar não encontrado"));
    }

    public Exemplar atualizarStatus(Long id, StatusExemplar status) {

        Exemplar exemplar = buscarExemplarPorId(id);

        exemplar.setStatus(status);

        return repository.save(exemplar);
    }

    public void deletarExemplar(Long id) {
       
        Exemplar exemplar = buscarExemplarPorId(id);

        repository.delete(exemplar);
    }
    
}
