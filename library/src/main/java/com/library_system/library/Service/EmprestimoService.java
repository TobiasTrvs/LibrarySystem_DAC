package com.library_system.library.Service;
import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library_system.library.Repository.EmprestimoRepository;
import com.library_system.library.Repository.ExemplarRepository;
import com.library_system.library.Repository.LivroRepository;
import com.library_system.library.Repository.PenalidadeRepository;
import com.library_system.library.Repository.UsuarioRepostitory;
import com.library_system.library.dto.emprestimo.EmprestimoRequestDTO;
import com.library_system.library.entity.Usuario;
import jakarta.transaction.Transactional;

import com.library_system.library.entity.Emprestimo;
import com.library_system.library.entity.Exemplar;
import com.library_system.library.entity.Livro;
import com.library_system.library.entity.StatusEmprestimo;
import com.library_system.library.entity.StatusPenalidade;

@Service

public class EmprestimoService {
    private final EmprestimoRepository repository;
    private UsuarioRepostitory usuarioRepository;
    private LivroRepository livroRepository;
    private ExemplarRepository exemplarRepository;
    private PenalidadeRepository penalidadeRepository;
    private Exemplar exemplar;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }


    // realizar empréstimo
    // terminar o método de aplicar penalidade e validar empréstimo para depois concluir esse método
    public Emprestimo realizarEmprestimo(EmprestimoRequestDTO dto) {
        validarEmprestimo(dto.getUsuarioID(), dto.getEmprestimoID()); // corrigir o parâmetrro passado para exemplar ID configurando o emprestimo requestDTO
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setStatus(StatusEmprestimo.ATIVO);
        emprestimo.setDataPrevistaDevolucao(LocalDate.now().plusDays(7));
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
    // fazer verificação de atraso e aplicar penalidade (caso realmente haja atraso)
    public Emprestimo registrarDevolucao(Long id) {
        Emprestimo emprestimo = buscarEmprestimoPorId(id);
        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setStatus(StatusEmprestimo.FINALIZADO);
        return repository.save(emprestimo);
    }

    // validar empréstimo
    public void validarEmprestimo(long usuarioID,  long exemplarID){

        Usuario usuario = usuarioRepository.findById(usuarioID).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Exemplar exemplar = exemplarRepository.findById(exemplarID).orElseThrow(() -> new RuntimeException("exemplar não encontrado")) ;
        if(penalidadeRepository.existsByUsuarioIdAndStatus(usuarioID,  StatusPenalidade.ATIVA)){
            throw new RuntimeException("Usuário possui penalidade ativa");        
        }
        // errado, pois o método deve apenas VALDAR O EMPRESTIMO. a realização do empréstimo em si, deve ser feita apenas no nétodo "realiizar empréstimo"
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setId(exemplarID);
        emprestimo.setStatus(StatusEmprestimo.ATIVO);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataPrevistaDevolucao(LocalDate.now().plusDays(7));
        repository.save(emprestimo);
        
    }

    //deletar empréstimo
    @Transactional
    public void deletarEmprestimo(long id){
        repository.deleteById(id);
        }
        
        // esse métodos vai buscar todos os exemplares com o id passado no findbyID;(só pra testes mesmo, não serve pra nada por enquanto)
        // Livro livro = livroRepository.findById(1L).get();
        // List <Exemplar> todosOsExemplares = livro.getExemplares();


    // por enquanto, esse método busca apenas os exemplares através do ID, mas não apenas os exemplares com status disponivel
    public List<Exemplar> buscarExemplares(long livroID){
        Livro livro = livroRepository.findById(livroID).orElseThrow(() -> new RuntimeException("exemplar não encontrado"));
        return livro.getExemplares();
    }
    }
