package com.library_system.library.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library_system.library.entity.Exemplar;
import com.library_system.library.entity.StatusExemplar;
@Repository

public interface ExemplarRepository extends JpaRepository <Exemplar, Long>{

    public List <Exemplar> findByLivroIdAndStatus(Long livroId, StatusExemplar status);
}
