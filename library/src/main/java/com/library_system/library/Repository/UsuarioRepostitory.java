package com.library_system.library.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library_system.library.entity.Usuario;

import jakarta.transaction.Transactional;

@Repository

public interface UsuarioRepostitory extends JpaRepository <Usuario, Long> {

    @Transactional
    public void deleteById(long id);

    public boolean existsByEmail(String email);
}

