package com.library_system.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library_system.library.entity.Penalidade;
import com.library_system.library.entity.StatusPenalidade;

public interface PenalidadeRepository extends JpaRepository <Penalidade, Long> {
    
    public boolean existsByUsuarioIdAndStatus(Long usuarioID, StatusPenalidade status);

}
