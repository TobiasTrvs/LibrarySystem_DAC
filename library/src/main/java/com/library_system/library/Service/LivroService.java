package com.library_system.library.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.library_system.library.Repository.LivroRepository;
import com.library_system.library.dto.LIvroRequestDTO;
import com.library_system.library.entity.Livro;
import jakarta.transaction.Transactional;
@Service

public class LivroService {

     private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro salvarLivro(LIvroRequestDTO dto) {
        if (repository.existsByIsbn(dto.getIsbn())){
            throw new RuntimeException("Esse livro já está cadastrado");
        }

        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        livro.setEditora(dto.getEditora());
        return repository.save(livro);
    }

    public List<Livro> listarLivros() {
        return repository.findAll();
    }

    public Livro buscarLivroPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro com ID " + id + " não encontrado"));
    }

    public Livro atualizarLivro(Long id, Livro livroAtualizado) {

        Livro livro = buscarLivroPorId(id);

        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setEditora(livroAtualizado.getEditora());
        livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
        livro.setIsbn(livroAtualizado.getIsbn());

        return repository.save(livro);
    }

    @Transactional
    public void deletarLivro(Long id) {
        Livro livro = buscarLivroPorId(id);

        repository.delete(livro);
    }
}

    

