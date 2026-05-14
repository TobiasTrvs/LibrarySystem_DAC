package com.library_system.library.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.library_system.library.Repository.ExemplarRepository;
import com.library_system.library.entity.Exemplar;
import com.library_system.library.entity.StatusExemplar;
@Service

public class ExemplarService {
     private final ExemplarRepository repository;

    public ExemplarService(ExemplarRepository repository) {
        this.repository = repository;
    }

    public Exemplar salvarExemplar(Exemplar exemplar) {
        return repository.save(exemplar);
    }

    public List<Exemplar> listarExemplares() {
        return repository.findAll();
    }

    public Exemplar buscarExemplarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exemplar com ID " + id + " não encontrado"));
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
