package com.library_system.library.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.library_system.library.Repository.LivroRepository;
import com.library_system.library.dto.livro.LIvroRequestDTO;
import com.library_system.library.dto.livro.LivroResponseDTO;
import com.library_system.library.entity.Livro;
import com.library_system.library.mapper.LivroMapper;

import jakarta.transaction.Transactional;
@Service

public class LivroService {

     private final LivroRepository livroRepository;

    public LivroService(LivroRepository repository) {
        this.livroRepository = repository;
    }

    public LivroResponseDTO salvarLivro(LIvroRequestDTO dto) {
        if (livroRepository.existsByIsbn(dto.getIsbn())){
            throw new RuntimeException("Esse livro já foi cadastrado");
        }

        Livro livro = LivroMapper.toEntity(dto);
        Livro livroSalvo = livroRepository.save(livro);
        return LivroMapper.toResponseDTO(livroSalvo);
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro buscarLivroPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro com ID " + id + " não encontrado"));
    }

    // alterar método para receber um dto
    public Livro atualizarLivro(Long id, Livro livroAtualizado) {

        Livro livro = buscarLivroPorId(id);

        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setEditora(livroAtualizado.getEditora());
        livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
        livro.setIsbn(livroAtualizado.getIsbn());

        return livroRepository.save(livro);
    }

    @Transactional
    public void deletarLivro(Long id) {
        Livro livro = buscarLivroPorId(id);
        livroRepository.delete(livro);
    }
}

    

