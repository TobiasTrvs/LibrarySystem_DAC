package com.library_system.library.Service;
import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library_system.library.Repository.EmprestimoRepository;
import com.library_system.library.Repository.ExemplarRepository;
import com.library_system.library.Repository.ItemEmprestimoRepository;
import com.library_system.library.Repository.LivroRepository;
import com.library_system.library.Repository.PenalidadeRepository;
import com.library_system.library.Repository.UsuarioRepostitory;
import com.library_system.library.dto.emprestimo.EmprestimoRequestDTO;
import com.library_system.library.dto.emprestimo.EmprestimoResponseDTO;
import com.library_system.library.dto.penalidade.PenalidadeRequestDTO;
import com.library_system.library.entity.Usuario;
import com.library_system.library.mapper.EmprestimoMapper;
import com.library_system.library.mapper.ItemEmprestimoMapper;

import jakarta.transaction.Transactional;
import com.library_system.library.entity.Emprestimo;
import com.library_system.library.entity.Exemplar;
import com.library_system.library.entity.ItemEmprestimo;
import com.library_system.library.entity.Livro;
import com.library_system.library.entity.Penalidade;
import com.library_system.library.entity.StatusEmprestimo;
import com.library_system.library.entity.StatusExemplar;
import com.library_system.library.entity.StatusPenalidade;

@Service
public class EmprestimoService {
    private final EmprestimoRepository repository;
    private final UsuarioRepostitory usuarioRepository;
    private final LivroRepository livroRepository;
    private final ExemplarRepository exemplarRepository;
    private final PenalidadeRepository penalidadeRepository;
    private Exemplar exemplar;
    private final PenalidadeService penalidadeService;

    public EmprestimoService(EmprestimoRepository repository, UsuarioRepostitory usuarioRepostitory, LivroRepository livroRepository, ExemplarRepository exemplarRepository, PenalidadeService penalidadeService, PenalidadeRepository penalidadeRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepostitory;
        this.livroRepository = livroRepository;
        this.exemplarRepository = exemplarRepository;
        this.penalidadeService = penalidadeService;
        this.penalidadeRepository = penalidadeRepository;
    }


    // realizar empréstimo
    // terminar o método de aplicar penalidade e validar empréstimo para depois concluir esse método
    public EmprestimoResponseDTO realizarEmprestimo(EmprestimoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioID()).orElseThrow(() ->new RuntimeException("Usuário não encontrado"));
         // corrigir o parâmetrro passado para exemplar ID configurando o emprestimo requestDTO
        // Emprestimo emprestimo = new Emprestimo();
        // emprestimo.setDataEmprestimo(LocalDate.now());
        // emprestimo.setStatus(StatusEmprestimo.ATIVO);
        // emprestimo.setDataPrevistaDevolucao(LocalDate.now().plusDays(7));
        Emprestimo emprestimo = EmprestimoMapper.toEntity(usuario);
        Emprestimo emprestimoSalvo = repository.save(emprestimo);
        ItemEmprestimo item = ItemEmprestimoMapper.toEntity(emprestimoSalvo, exemplar);
        // itemEmprestimoRepository.save(item);
        exemplar.setStatus(StatusExemplar.EMPRESTADO);
        exemplarRepository.save(exemplar);


        return EmprestimoMapper.toResponseDTO(emprestimoSalvo);
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
    public Emprestimo registrarDevolucao(EmprestimoRequestDTO dto) {
        if (verificarAtraso(dto.getDataDevolucao(), dto.getDataPrevistaDevolucao())){
            PenalidadeRequestDTO penalidadeDTO  = new PenalidadeRequestDTO();
            penalidadeDTO.setUsuarioId(dto.getUsuarioID());
            penalidadeDTO.setMotivo("atraso na devolução do livro");
            penalidadeDTO.setDataFim(dto.getDataDevolucao().plusDays(7));
            penalidadeService.aplicarPenalidade(penalidadeDTO);
        }
        Emprestimo emprestimo = buscarEmprestimoPorId(dto.getLivroID());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());
        emprestimo.setStatus(StatusEmprestimo.FINALIZADO);
        return repository.save(emprestimo);
    }
    


    // validar empréstimo (lembrar de verificar se o usuário atingiu o limite de empéstimo, logo após verificar se o mesmo possui penalidade ativa)
    public void validarEmprestimo(long usuarioID,long livroID){
        usuarioRepository.findById(usuarioID).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        exemplarRepository.findByLivroIdAndStatus(livroID, StatusExemplar.DISPONIVEL);
        if(penalidadeRepository.existsByUsuarioIdAndStatus(usuarioID,  StatusPenalidade.ATIVA)){
            throw new RuntimeException("Usuário possui penalidade ativa");        
        } 
    }

    //deletar empréstimo
    @Transactional
    public void deletarEmprestimo(long id){
        repository.deleteById(id);
        }
        
        // esse métodos vai buscar todos os exemplares com o id passado no findbyID;(só pra testes mesmo, não serve pra nada por enquanto)
        // Livro livro = livroRepository.findById(1L).get();
        // List <Exemplar> todosOsExemplares = livro.getExemplares();


        //  por enquanto, esse método busca apenas os exemplares através do ID, mas não apenas os exemplares com status disponivel
        // public List<Exemplar> buscarExemplares(long livroID){
        //     Livro livro = livroRepository.findById(livroID).orElseThrow(() -> new RuntimeException("exemplar não encontrado"));
        //     return livro.getExemplares();
        // }

    // verficar se houve atraso na devolução
    public boolean verificarAtraso(LocalDate dataDevolucao, LocalDate dataPrevista){
        return dataDevolucao.isAfter(dataPrevista); 
    }
}
