package com.library_system.library.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library_system.library.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Long>{

    public boolean existsByIsbn(String isbn);
    
}
