package com.library_system.library.Service;
import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library_system.library.Repository.EmprestimoRepository;
import com.library_system.library.Repository.ExemplarRepository;
import com.library_system.library.Repository.LivroRepository;
import com.library_system.library.Repository.UsuarioRepostitory;
import com.library_system.library.entity.Usuario;
import com.library_system.library.dto.EmprestimoRequestDTO;
import com.library_system.library.entity.Emprestimo;
import com.library_system.library.entity.Livro;
import com.library_system.library.entity.StatusEmprestimo;
import com.library_system.library.entity.Usuario;

@Service

public class EmprestimoService {
    private final EmprestimoRepository repository;
    private UsuarioRepostitory usuarioRepository;
    private LivroRepository livroRepository;
     private ExemplarRepository exemplarRepository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }


    // realizar empréstimo
    public Emprestimo realizarEmprestimo(EmprestimoRequestDTO dto) {
        if (repository.validarEmprestimo(dto.getUsuarioID(), dto.getEmprestimoID())){

        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setStatus(StatusEmprestimo.ATIVO);

        return repository.save(emprestimo);
    }

    //listar empréstimos
    public List<Emprestimo> listarEmprestimos() {
        return repository.findAll();
    }

    //buscar empréstimo por ID
    public Emprestimo buscarEmprestimoPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Esse empréstimo não existe"));
    }

    // registrar devolução
    public Emprestimo registrarDevolucao(Long id) {
        Emprestimo emprestimo = buscarEmprestimoPorId(id);
        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setStatus(StatusEmprestimo.FINALIZADO);
        return repository.save(emprestimo);
    }

    // validar empréstimo
    public boolean validarEmprestimo(long usuarioID,  long exemplarID){

        Usuario usuario = usuarioRepostitory.findById(usuarioID).orElseThrow(() -> new RuntimeException("Esse empréstimo não existe"));
        Livro livro = LivroRepository.findById(exemplarID);
    
        

        

       
        return true;
    }

    //deletar empréstimo
    public void deletarEmprestimo(long id){
        repository.deleteById(id);
        }    
    }
