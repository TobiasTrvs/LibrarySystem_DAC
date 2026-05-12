package com.library_system.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library_system.library.entity.Livro;


public interface LivroRepository extends JpaRepository <Livro, Long>{
    
}
